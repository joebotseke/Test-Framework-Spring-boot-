package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture() {
        Voiture voiture1 = new Voiture("Peugeot", 40000);

        // Test des infos de la voiture
        Assert.isTrue(voiture1.getMarque().equals("Peugeot"), "La marque de la voiture doit être 'Peugeot'");
        Assert.isTrue(voiture1.getPrix() == 40000, "Le prix de la voiture doit être de 40000");

        // Test modification de marque et prix
        voiture1.setMarque("Renault");
        voiture1.setPrix(35000);

        Assert.isTrue(voiture1.getMarque().equals("Renault"), "La marque de la voiture doit être 'Renault'");
        Assert.isTrue(voiture1.getPrix() == 35000, "Le prix de la voiture doit être de 35000");
    }

    @Test
    void comparerVoitures() {
        Voiture voiture1 = new Voiture("Peugeot", 40000);
        Voiture voiture2 = new Voiture("Renault", 35000);

        // Test comparaison de deux voitures par leur prix
        Assert.isTrue(voiture1.compareTo(voiture2) > 0, "La voiture 1 doit être plus chère que la voiture 2");
    }

    @Test
    void modifierMarque() {
        Voiture voiture1 = new Voiture("Peugeot", 40000);

        // Test modification de la marque de la voiture
        voiture1.setMarque("Citroen");

        Assert.isTrue(voiture1.getMarque().equals("Citroen"), "La marque de la voiture doit être 'Citroen'");
    }

    @Test
    void modifierPrix() {
        Voiture voiture1 = new Voiture("Peugeot", 40000);

        // Test modification du prix de la voiture
        voiture1.setPrix(45000);

        Assert.isTrue(voiture1.getPrix() == 45000, "Le prix de la voiture doit être de 45000");
    }

    @Test
    void verifierType() {
        Voiture voiture1 = new Voiture("Peugeot", 40000);

        // Test vérification du type de la voiture
        Assert.isTrue(voiture1 instanceof Voiture, "L'objet doit être une instance de la classe 'Voiture'");
    }
}
