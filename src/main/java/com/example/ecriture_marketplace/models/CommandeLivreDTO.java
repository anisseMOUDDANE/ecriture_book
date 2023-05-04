package com.example.ecriture_marketplace.models;



public class CommandeLivreDTO {
    private Long idLivre;
    private Integer quantite;

    public void setIdLivre(Long idLivre) {
        this.idLivre = idLivre;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Long getIdLivre() {
        return idLivre;
    }

    public Integer getQuantite() {
        return quantite;
    }
}
