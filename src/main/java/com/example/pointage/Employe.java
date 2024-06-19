package com.example.pointage;

import com.example.pointage.categorie.Categorie;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Employe {
    private String nom;
    private String prenom;
    private String numeroMatricule;
    private LocalDate dateNaissance;
    private LocalDate dateEmbauche;
    private LocalDate dateFinContrat;
    private double salaireBrut;
    private double salaireNet;
    private Categorie categorie;
    private HeureTravaille heureTravaille;

    public Employe(String nom, String prenom, String numeroMatricule, LocalDate dateNaissance,
                   LocalDate dateEmbauche, LocalDate dateFinContrat, double salaireBrut,
                   Categorie categorie, HeureTravaille heureTravaille) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroMatricule = numeroMatricule;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.dateFinContrat = dateFinContrat;
        this.salaireBrut = salaireBrut;
        this.categorie = categorie;
        this.salaireNet = salaireBrut * 0.8;
        this.heureTravaille = heureTravaille;
    }

    public double calculerHeuresSupplementairesEtSalaire() {
        double tauxHoraireNormal = categorie.getTauxHoraire();

        int heuresSupplementaires = heureTravaille.getHeuresSupplementaires();
        double salaireSupp = 0.0;

        if (heuresSupplementaires > 0) {
            int heuresHS30 = Math.min(8, heuresSupplementaires);
            int heuresHS50 = Math.min(12, Math.max(0, heuresSupplementaires - 8));

            salaireSupp += heuresHS30 * tauxHoraireNormal * 1.3;
            salaireSupp += heuresHS50 * tauxHoraireNormal * 1.5;
        }

        return salaireSupp;
    }

    public int calculerHeuresSupplementaires() {
        int heuresNormales = categorie.getHeuresNormalesParSemaine();
        int heuresSupp = Math.max(0, heureTravaille.getHeuresNormales() - heuresNormales);
        return Math.min(heuresSupp, 20);
    }

    public double calculerSalaireTotal() {
        double salaireBase = categorie.getSalaireParSemaine();
        double salaireHeuresSupp = calculerHeuresSupplementairesEtSalaire();
        return salaireBase + salaireHeuresSupp;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Prénom: " + prenom +
                ", Matricule: " + numeroMatricule +
                ", Date de naissance: " + dateNaissance +
                ", Date d'embauche: " + dateEmbauche +
                ", Date de fin de contrat: " + dateFinContrat +
                ", Salaire brut: " + salaireBrut +
                ", Salaire net: " + salaireNet +
                ", Catégorie: " + categorie.getNom() +
                ", Indemnité: " + categorie.calculerIndemnite() +
                ", Heures normales travaillées: " + heureTravaille.getHeuresNormales() +
                ", Heures supplémentaires: " + heureTravaille.getHeuresSupplementaires() +
                ", Heures de majoration: " + heureTravaille.getHeuresMajoration() +
                ", Salaire total: " + calculerSalaireTotal();
    }


}
