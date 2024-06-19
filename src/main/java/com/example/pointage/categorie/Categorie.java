package com.example.pointage.categorie;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Categorie {
    private String nom;
    private int heuresNormalesParSemaine;
    private double salaireParSemaine;

    public Categorie(String nom, int heuresNormalesParSemaine, double salaireParSemaine) {
        this.nom = nom;
        this.heuresNormalesParSemaine = heuresNormalesParSemaine;
        this.salaireParSemaine = salaireParSemaine;
        calculerIndemnite();
    }
    public abstract void calculerIndemnite();

}
