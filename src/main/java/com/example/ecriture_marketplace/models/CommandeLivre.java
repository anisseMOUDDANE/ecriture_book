package com.example.ecriture_marketplace.models;


import jakarta.persistence.*;

@Entity
@Table(name = "commandelivre")
public class CommandeLivre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande_livre")
    private Long idCommande;

    @Column(name = "id_commande")
    private Long idCommandeLivre;

    @Column(name = "id_livre")
    private Long idLivre;

    @Column(name = "quantite")
    private Integer quantite;

    // Getters and Setters

    public Long getIdCommande() {
        return idCommande;
    }

    public Long getIdLivre() {
        return idLivre;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public void setIdLivre(Long idLivre) {
        this.idLivre = idLivre;
    }


    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }


    public Long getIdCommandeLivre() {
        return idCommandeLivre;
    }

    public void setIdCommandeLivre(Long idCommandeLivre) {
        this.idCommandeLivre = idCommandeLivre;
    }
}
