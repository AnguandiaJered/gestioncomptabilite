package com.example.comptability.models;

import javax.persistence.*;
import java.util.Date;

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

    public String getRefcaisse() {
        return refcaisse;
    }

    public void setRefcaisse(String refcaisse) {
        this.refcaisse = refcaisse;
    }

    public Date getDaterecette() {
        return daterecette;
    }

    public void setDaterecette(Date daterecette) {
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
    @Column(nullable = false, length = 300 , name = "refcaisse")
    private  String refcaisse;
    @Column(nullable = false, length = 300 , name = "daterecette")
    private Date daterecette;
    @Column(nullable = false, length = 300 , name = "author")
    private String author;
}
