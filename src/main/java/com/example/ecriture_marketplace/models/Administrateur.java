package com.example.ecriture_marketplace.models;

import jakarta.persistence.*;

@Entity
@Table(name = "administrateur")
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *
     * id
     * identifiant
     * password
     */

    @Column(name = "identifiant")
    private String identifiant;

    @Column(name = "password")
    private String password;

    //getters and setters

    public String getIdentifiant() {
        return identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
