package com.example.ecriture_marketplace;

import com.example.ecriture_marketplace.models.ConditionsDeVentes;
import com.example.ecriture_marketplace.repository.ConditionsDeVentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/conditionsDeVentes")
public class ConditionsDeVentesController {

    @Autowired
    private ConditionsDeVentesRepository repository;

    @PostMapping("/")
    public ResponseEntity<ConditionsDeVentes> create(@RequestBody ConditionsDeVentes conditionsDeVentes) {
        ConditionsDeVentes savedConditionsDeVentes = repository.save(conditionsDeVentes);
        return new ResponseEntity<>(savedConditionsDeVentes, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConditionsDeVentes> update(@PathVariable Long id, @RequestBody ConditionsDeVentes conditionsDeVentes) {
        Optional<ConditionsDeVentes> optionalConditionsDeVentes = repository.findById(id);
        if (optionalConditionsDeVentes.isPresent()) {
            ConditionsDeVentes existingConditionsDeVentes = optionalConditionsDeVentes.get();
            existingConditionsDeVentes.setId_librairie(conditionsDeVentes.getId_librairie());
            existingConditionsDeVentes.setLink_doc_pdf(conditionsDeVentes.getLink_doc_pdf());
            ConditionsDeVentes updatedConditionsDeVentes = repository.save(existingConditionsDeVentes);
            return new ResponseEntity<>(updatedConditionsDeVentes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<ConditionsDeVentes> optionalConditionsDeVentes = repository.findById(id);
        if (optionalConditionsDeVentes.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

