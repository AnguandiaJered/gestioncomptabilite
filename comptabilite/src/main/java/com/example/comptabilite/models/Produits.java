package com.example.comptabilite.models;

import javax.persistence.*;

@Entity
@Table(name = "produits")
public class Produits {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 300 , name = "designation")
    private String designation;
    @Column(nullable = false, length = 300, name = "quantite")
    private Double quantite;
    @Column(nullable = false, length = 300, name = "prix")
    private Double prix;
    @Column(nullable = false, length = 300, name = "categorie")
    private String categorie;
}
