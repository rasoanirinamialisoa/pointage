package com.example.pointage;

public class HeureTravaille {
    private int heuresNormales;
    private int heuresSupplementaires;
    private int heuresMajoration;

    public HeureTravaille(int heuresNormales, int heuresSupplementaires, int heuresMajoration) {
        this.heuresNormales = heuresNormales;
        this.heuresSupplementaires = heuresSupplementaires;
        this.heuresMajoration = heuresMajoration;
    }

    public int getHeuresNormales() {
        return heuresNormales;
    }

    public void setHeuresNormales(int heuresNormales) {
        this.heuresNormales = heuresNormales;
    }

    public int getHeuresSupplementaires() {
        return heuresSupplementaires;
    }

    public void setHeuresSupplementaires(int heuresSupplementaires) {
        this.heuresSupplementaires = heuresSupplementaires;
    }

    public int getHeuresMajoration() {
        return heuresMajoration;
    }

    public void setHeuresMajoration(int heuresMajoration) {
        this.heuresMajoration = heuresMajoration;
    }
}
