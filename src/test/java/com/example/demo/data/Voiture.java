package com.example.demo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Voiture implements Comparable<Voiture> {
    private int id;
    private String marque;
    private int prix;


    public Voiture(String marque, int prix) {
        this.marque = marque;
        this.prix = prix;
    }

    public Voiture() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String nouvelleMarque) {
        this.marque = nouvelleMarque;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int nouveauPrix) {
        this.prix = nouveauPrix;
    }

    @Override
    public String toString() {
        return "Cette voiture n°" + this.getId() + " a été fabriquée par : " + this.getMarque() + " et elle coûte : " + this.getPrix() + "€";
    }

    @Override
    public int compareTo(Voiture autreVoiture) {
        if (this.getPrix() < autreVoiture.getPrix()) {
            return -1;
        } else if (this.getPrix() > autreVoiture.getPrix()) {
            return 1;
        } else {
            return 0;
        }
    }
}
