package com.example.ecriture_marketplace.repository;

import com.example.ecriture_marketplace.models.CommandeLivre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeLivreRepository extends JpaRepository<CommandeLivre, Long> {
}
