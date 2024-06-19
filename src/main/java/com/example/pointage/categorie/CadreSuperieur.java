package com.example.pointage.categorie;

public class CadreSuperieur extends Categorie {
    private double montantIndeminte;
    public CadreSuperieur(String nom, int heuresNormalesParSemaine, double salaireParSemaine) {
        super(nom, heuresNormalesParSemaine, salaireParSemaine);
    }
    @Override
    public void calculerIndemnite() {
        this.montantIndeminte = getSalaireParSemaine() * 0.2;
    }

}

