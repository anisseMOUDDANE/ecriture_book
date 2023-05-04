package com.example.ecriture_marketplace.repository;

import com.example.ecriture_marketplace.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}

