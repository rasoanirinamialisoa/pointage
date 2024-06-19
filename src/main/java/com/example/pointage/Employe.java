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
    public Employe(String nom, String prenom, String numeroMatricule, LocalDate dateNaissance,
                   LocalDate dateEmbauche, LocalDate dateFinContrat, double salaireBrut,
                   Categorie categorie) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroMatricule = numeroMatricule;
        this.dateNaissance = dateNaissance;
        this.dateEmbauche = dateEmbauche;
        this.dateFinContrat = dateFinContrat;
        this.salaireBrut = salaireBrut;
        this.categorie = categorie;
        this.salaireNet = salaireBrut * 0.8;
    }

    public double calculerHeuresSupplementairesEtSalaire(double heuresTravaillees) {
        double heuresNormales = categorie.getHeuresNormalesParSemaine();
        double tauxHoraireNormal = categorie.getSalaireParSemaine() / heuresNormales;

        double heuresSupp = Math.max(0, heuresTravaillees - heuresNormales);
        double heuresSuppPayees = Math.min(heuresSupp, 20);

        double salaireSupp = 0.0;

        if (heuresSuppPayees > 0) {
            double heuresHS30 = Math.min(8, heuresSuppPayees);
            double heuresHS50 = Math.min(12, Math.max(0, heuresSuppPayees - 8));

            salaireSupp += heuresHS30 * tauxHoraireNormal * 1.3;
            salaireSupp += heuresHS50 * tauxHoraireNormal * 1.5;
        }

        return salaireSupp;
    }
}
