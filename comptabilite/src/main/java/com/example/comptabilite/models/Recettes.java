package com.example.comptabilite.models;

import javax.persistence.*;

@Entity
@Table(name = "recettes")
public class Recettes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getRefvente() {
        return refvente;
    }

    public void setRefvente(String refvente) {
        this.refvente = refvente;
    }

    public String getDaterecette() {
        return daterecette;
    }

    public void setDaterecette(String daterecette) {
        this.daterecette = daterecette;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Column(nullable = false, length = 300 , name = "montant")
    private Double montant;
    @Column(nullable = false, length = 300 , name = "motif")
    private String motif;
    @Column(nullable = false, length = 300 , name = "refvente")
    private  String refvente;
    @Column(nullable = false, length = 300 , name = "daterecette")
    private String daterecette;
    @Column(nullable = false, length = 300 , name = "author")
    private String author;
}
