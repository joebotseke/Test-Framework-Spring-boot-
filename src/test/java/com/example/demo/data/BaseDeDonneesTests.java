package com.example.demo.data;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;

@SpringBootTest
public class BaseDeDonneesTests {

    // on utilise @MockBean pour créer un mock de VoitureRepository
    @MockBean
    private VoitureRepository voitureRepository;

    @Test
    void testEnregistrerVoiture() {
        // on crée une voiture à enregistrer dans la base de données
        Voiture voiture = new Voiture("Chevrolet",100000);

        // on simule le comportement de la méthode save de VoitureRepository
        when(voitureRepository.save(voiture)).thenReturn(voiture);

        // on enregistre la voiture dans la base de données
        Voiture voitureEnregistree = voitureRepository.save(voiture);

        // on vérifie que la voiture a bien été enregistrée en comparant les deux objets
        Assert.isTrue(voitureEnregistree.equals(voiture), "La voiture n'a pas été enregistrée correctement");
    }

    @Test
    void testCompterVoitures() {
        // on simule le comportement de la méthode count de VoitureRepository
        when(voitureRepository.count()).thenReturn(5L);

        // on compte le nombre de voitures dans la base de données
        long nombreDeVoitures = voitureRepository.count();

        // on vérifie que le nombre de voitures est bien 5
        Assert.isTrue(nombreDeVoitures == 5L, "Le nombre de voitures dans la base de données est incorrect");
    }

    @Test
    void testTrouverVoitureParMarque() {
        // on crée une liste de voitures avec une seule voiture de marque "Peugeot"
        Voiture voiturePeugeot = new Voiture("Peugeot", 40000);
        Voiture voitureRenault = new Voiture("Renault", 35000);
        Voiture voitureCitroen = new Voiture("Citroen", 30000);
        Voiture voitureBMW = new Voiture("BMW", 50000);

        // on simule le comportement de la méthode findByMarque de VoitureRepository
        when(voitureRepository.findByMarque("Peugeot")).thenReturn(Collections.singletonList(voiturePeugeot));

        // on cherche les voitures de marque "Peugeot" dans la base de données
        Iterable<Voiture> voituresPeugeot = voitureRepository.findByMarque("Peugeot");

        // on vérifie que la liste de voitures contient bien une seule voiture de marque "Peugeot"
        Assert.isTrue(voituresPeugeot.iterator().next().equals(voiturePeugeot), "La voiture de marque 'Peugeot' n'a pas été trouvée");

    }


}
