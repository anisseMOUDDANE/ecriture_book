package com.example.ecriture_marketplace;

import com.example.ecriture_marketplace.models.CommandeLivre;
import com.example.ecriture_marketplace.repository.CommandeLivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/commandelivre")
public class CommandeLivreController {

    @Autowired
    private CommandeLivreRepository commandeLivreRepository;

    @PostMapping("/")
    public ResponseEntity<CommandeLivre> createCommandeLivre(@RequestBody CommandeLivre commandeLivre) {
        CommandeLivre savedCommandeLivre = commandeLivreRepository.save(commandeLivre);
        return new ResponseEntity<>(savedCommandeLivre, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommandeLivre> updateCommandeLivre(@PathVariable Long id, @RequestBody CommandeLivre commandeLivre) {
        Optional<CommandeLivre> optionalCommandeLivre = commandeLivreRepository.findById(id);
        if (optionalCommandeLivre.isPresent()) {
            CommandeLivre existingCommandeLivre = optionalCommandeLivre.get();
            existingCommandeLivre.setIdCommande(commandeLivre.getIdCommande());
            existingCommandeLivre.setIdLivre(commandeLivre.getIdLivre());
            existingCommandeLivre.setIdCommandeLivre(commandeLivre.getIdCommandeLivre());
            existingCommandeLivre.setQuantite(commandeLivre.getQuantite());
            CommandeLivre updatedCommandeLivre = commandeLivreRepository.save(existingCommandeLivre);
            return new ResponseEntity<>(updatedCommandeLivre, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommandeLivre(@PathVariable Long id) {
        commandeLivreRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
