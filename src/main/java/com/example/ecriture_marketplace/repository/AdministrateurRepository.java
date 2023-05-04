package com.example.ecriture_marketplace.repository;

import com.example.ecriture_marketplace.models.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministrateurRepository extends JpaRepository<Administrateur, Long> {
}
