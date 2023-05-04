package com.example.ecriture_marketplace.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "commande")
public class Commande{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private LocalDate dateCommande;

    @Column(name = "etat")
    private String etat;

    @Column(name = "id_librairie")
    private Long idLibrairie;

    @Column(name = "id_client")
    private Long idClient;


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public String getEtat() {
        return etat;
    }

    public Long getIdLibrairie() {
        return idLibrairie;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setIdLibrairie(Long idLibrairie) {
        this.idLibrairie = idLibrairie;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    // toString
    @Override
    public String toString() {
        return "Commande [id=" + id + ", dateCommande=" + dateCommande + ", etat=" + etat + ", idLibrairie="
                + idLibrairie + ", idClient=" + idClient + "]";
    }
}

