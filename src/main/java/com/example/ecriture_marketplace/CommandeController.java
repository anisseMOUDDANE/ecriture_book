package com.example.ecriture_marketplace;
import com.example.ecriture_marketplace.models.*;
import com.example.ecriture_marketplace.repository.ClientRepository;
import com.example.ecriture_marketplace.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.ecriture_marketplace.repository.CommandeLivreRepository;

import java.util.Optional;


@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private CommandeLivreRepository commandeLivreRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("")
    public ResponseEntity<Commande> creerCommande(@RequestBody Commande commande) {
        Commande nouvelleCommande = commandeRepository.save(commande);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleCommande);
    }

    /**
     * JSON Attendu :
     * {
     *   "date": "2023-05-04",
     *   "idLibrairie": 1,
     *   "idClient": 1,
     *   "commandesLivres": [
     *     {
     *       "idLivre": 1,
     *       "quantite": 2
     *     },
     *     {
     *       "idLivre": 2,
     *       "quantite": 1
     *     }
     *   ]
     * }
     * @param commandeDTO
     * @return
     * TODO : Gérer les erreurs dans le cas ou l'id n'existe pas dans la table livre ou librairie
     */
    @PostMapping("/newcommande")
    public ResponseEntity<String> creerCommande(@RequestBody CommandeDTO commandeDTO) {
        // Créer une instance de Commande à partir de CommandeDTO
        Commande commande = new Commande();
        commande.setDateCommande(commandeDTO.getDate());
        commande.setIdLibrairie(commandeDTO.getIdLibrairie());
        Optional<Client> optionalClient = clientRepository  .findById(commandeDTO.getIdClient());
        if (optionalClient.isEmpty()) {
            return ResponseEntity.badRequest().body("Le client avec l'id " + commandeDTO.getIdClient() + " n'existe pas.");
        }
        commande.setIdClient(commandeDTO.getIdClient());
        commande.setEtat("En cours");

        // Enregistrer la commande dans la base de données
        Commande savedCommande = commandeRepository.save(commande);

        // Pour chaque CommandeLivreDTO, créer une instance de CommandeLivre et l'associer à la commande
        for (CommandeLivreDTO commandeLivreDTO : commandeDTO.getCommandesLivres()) {
            CommandeLivre commandeLivre = new CommandeLivre();
            commandeLivre.setIdCommandeLivre(savedCommande.getId());
            commandeLivre.setIdLivre(commandeLivreDTO.getIdLivre());
            commandeLivre.setQuantite(commandeLivreDTO.getQuantite());

            commandeLivreRepository.save(commandeLivre);
        }

        return ResponseEntity.ok("Commande créée avec succès ! ");
    }


    // Méthode pour mettre à jour une commande existante
    @PutMapping("/{id}")
    public ResponseEntity<Commande> mettreAJourCommande(@PathVariable Long id, @RequestBody Commande commande) {
        Optional<Commande> optionalCommande = commandeRepository.findById(id);
        if (optionalCommande.isPresent()) {
            commande.setId(id);
            Commande commandeMiseAJour = commandeRepository.save(commande);
            return ResponseEntity.ok(commandeMiseAJour);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Méthode pour supprimer une commande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCommande(@PathVariable Long id) {
        Optional<Commande> optionalCommande = commandeRepository.findById(id);
        if (optionalCommande.isPresent()) {
            commandeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}