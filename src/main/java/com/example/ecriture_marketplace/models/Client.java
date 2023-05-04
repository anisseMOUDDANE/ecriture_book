package com.example.ecriture_marketplace.models;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * nom
     * siret
     * sirene
     * adresse
     * telehpone
     * email
     * */

    @Column(name = "nom")
    private String nom;

    @Column(name = "siret")
    private String siret;

    @Column(name = "sirene")
    private String sirene;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "email")
    private String email;

    //getters and setters

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

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
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

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
