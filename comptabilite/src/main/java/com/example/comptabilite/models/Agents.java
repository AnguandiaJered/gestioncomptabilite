package com.example.comptabilite.models;

import javax.persistence.*;

@Entity
public class Agents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoms() {
        return noms;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @Column(nullable = false, length = 300 , name = "noms")
    private String noms;
    @Column(nullable = false, length = 300 , name = "sexe")
    private String sexe;
    @Column(nullable = false, length = 300 , name = "datenaissance")
    private String datenaissance;
    @Column(nullable = false, length = 300 , name = "adresse")
    private String adresse;
    @Column(nullable = false, length = 300 , name = "telephone")
    private String telephone;
    @Column(nullable = false, length = 300 , name = "fonction")
    private String fonction;
}
