package com.example.timekeeping;

import com.example.timekeeping.category.Categorie;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeTest {
    @Test
    void testCalculHeuresSupplementaires() {
        Categorie categorieNormale = new Categorie("normal", 40, 100000, 0);
        Employe employe = new Employe("John", "Doe", "12345", LocalDate.of(1990, 1, 1),
                LocalDate.of(2020, 1, 1), null, 500000, categorieNormale);

        double salaireSupp = employe.calculerHeuresSupplementairesEtSalaire(40);
        assertEquals(0, salaireSupp);

        salaireSupp = employe.calculerHeuresSupplementairesEtSalaire(48);
        assertEquals(100000 / 40 * 8 * 1.3, salaireSupp);

        salaireSupp = employe.calculerHeuresSupplementairesEtSalaire(60);
        double expected = 100000 / 40 * 8 * 1.3 + 100000 / 40 * 12 * 1.5;
        assertEquals(expected, salaireSupp);

        salaireSupp = employe.calculerHeuresSupplementairesEtSalaire(70);
        assertEquals(expected, salaireSupp);
    }
}

