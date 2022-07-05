package com.example.comptabilite.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ventes")
public class Ventes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefproduit() {
        return refproduit;
    }

    public void setRefproduit(String refproduit) {
        this.refproduit = refproduit;
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

    public String getDatevente() {
        return datevente;
    }

    public void setDatevente(String datevente) {
        this.datevente = datevente;
    }
    @Column(nullable = false, length = 300 , name = "refproduit")
    private String refproduit;
    @Column(nullable = false, length = 300 , name = "quantite")
    private Double quantite;
    @Column(nullable = false, length = 300 , name = "prix")
    private Double prix;
    @Column(nullable = false, length = 300 , name = "datevente")
    private String datevente;
}
