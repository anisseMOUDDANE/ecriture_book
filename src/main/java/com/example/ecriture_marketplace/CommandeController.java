package com.example.ecriture_marketplace;
import com.example.ecriture_marketplace.models.Client;
import com.example.ecriture_marketplace.models.Commande;
import com.example.ecriture_marketplace.repository.ClientRepository;
import com.example.ecriture_marketplace.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    // Méthode pour créer une nouvelle commande
    @PostMapping("")
    public ResponseEntity<Commande> creerCommande(@RequestBody Commande commande) {
        Commande nouvelleCommande = commandeRepository.save(commande);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleCommande);
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