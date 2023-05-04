package com.example.ecriture_marketplace.models;

import jakarta.persistence.*;

@Entity
@Table(name = "conditionsdeventes")
public class ConditionsDeVentes {

    /*
    id_condition_de_vente
id_librairie
link_doc_pdf
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_condition_de_vente;

    @Column(name = "id_librairie")
    private Long id_librairie;

    @Column(name = "link_doc_pdf")
    private String link_doc_pdf;

    public Long getId_condition_de_vente() {
        return id_condition_de_vente;
    }

    public void setId_condition_de_vente(Long id_condition_de_vente) {
        this.id_condition_de_vente = id_condition_de_vente;
    }

    public Long getId_librairie() {
        return id_librairie;
    }

    public void setId_librairie(Long id_librairie) {
        this.id_librairie = id_librairie;
    }

    public String getLink_doc_pdf() {
        return link_doc_pdf;
    }

    public void setLink_doc_pdf(String link_doc_pdf) {
        this.link_doc_pdf = link_doc_pdf;
    }

}
