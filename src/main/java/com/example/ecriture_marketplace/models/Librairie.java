package com.example.ecriture_marketplace.models;

import jakarta.persistence.*;

@Entity
@Table(name = "librairie")
public class Librairie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "siret")
    private String siret;

    @Column(name = "sirene")
    private String sirene;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "email")
    private String email;

    @Column(name = "telephones")
    private String telephones;

    @Column(name = "identifiant")
    private String identifiant;

    @Column(name = "mot_de_passe")
    private String motDePasse;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getSiret() {
        return siret;
    }

    public String getSirene() {
        return sirene;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephones() {
        return telephones;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public void setSirene(String sirene) {
        this.sirene = sirene;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephones(String telephones) {
        this.telephones = telephones;
    }


    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }


}

