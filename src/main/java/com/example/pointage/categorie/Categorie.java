package com.example.pointage.categorie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Categorie {
    private String nom;
    private int heuresNormalesParSemaine;
    private double salaireParSemaine;
    private double montantIndemnite;
    public Categorie(String nom, int heuresNormalesParSemaine, double salaireParSemaine, double montantIndemnite) {
        this.nom = nom;
        this.heuresNormalesParSemaine = heuresNormalesParSemaine;
        this.salaireParSemaine = salaireParSemaine;
        this.montantIndemnite = montantIndemnite;
    }
}
