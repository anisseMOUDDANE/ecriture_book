package com.example.ecriture_marketplace.repository;

import com.example.ecriture_marketplace.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
