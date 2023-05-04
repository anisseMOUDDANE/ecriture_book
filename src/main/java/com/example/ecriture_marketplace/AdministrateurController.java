package com.example.ecriture_marketplace;

import com.example.ecriture_marketplace.models.Administrateur;
import com.example.ecriture_marketplace.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrateurs")
public class AdministrateurController {

    @Autowired
    private AdministrateurRepository administrateurRepository;

    @GetMapping("")
    public List<Administrateur> getAllAdministrateurs() {
        return administrateurRepository.findAll();
    }

    @GetMapping("/{id}")
    public Administrateur getAdministrateurById(@PathVariable Long id) {
        return administrateurRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public Administrateur createAdministrateur(@RequestBody Administrateur administrateur) {
        return administrateurRepository.save(administrateur);
    }

    @PutMapping("/{id}")
    public Administrateur updateAdministrateur(@PathVariable Long id, @RequestBody Administrateur administrateur) {
        administrateur.setId(id);
        return administrateurRepository.save(administrateur);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministrateur(@PathVariable Long id) {
        administrateurRepository.deleteById(id);
    }
}
