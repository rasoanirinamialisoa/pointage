package com.example.timekeeping;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CalendrierTravail {
    private Set<LocalDate> joursFeries;

    public CalendrierTravail() {
        this.joursFeries = new HashSet<>();
        this.joursFeries.add(LocalDate.of(2024, 6, 17));
        this.joursFeries.add(LocalDate.of(2024, 6, 25));
        this.joursFeries.add(LocalDate.of(2024, 6, 26));
    }
    public boolean estFerie(LocalDate date) {
        return joursFeries.contains(date);
    }

    // Méthodes supplémentaires pour gérer les jours ouvrables, etc.
}
