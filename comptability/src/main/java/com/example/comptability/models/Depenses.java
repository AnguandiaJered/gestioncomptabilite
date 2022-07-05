package com.example.comptability.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "depenses")
public class Depenses {
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

    public String getRefcaisse() {
        return refcaisse;
    }

    public void setRefcaisse(String refcaisse) {
        this.refcaisse = refcaisse;
    }

    public String getDatedepense() {
        return datedepense;
    }

    public void setDatedepense(String datedepense) {
        this.datedepense = datedepense;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 300 , name = "montant")
    private Double montant;
    @Column(nullable = false, length = 300 , name = "motif")
    private String motif;
    @Column(nullable = false, length = 300 , name = "refcaisse")
    private  String refcaisse;
    @Column(nullable = false, length = 300 , name = "datedepense")
    private String datedepense;
    @Column(nullable = false, length = 300 , name = "author")
    private String author;

}
