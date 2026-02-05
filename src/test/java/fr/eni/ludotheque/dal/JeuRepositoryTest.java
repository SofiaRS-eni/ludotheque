package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Genres;
import fr.eni.ludotheque.bo.Jeu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class JeuRepositoryTest {
    @Autowired
    private JeuRepository jeuRepository;
    @Autowired
    private GenresRepository genresRepository;

    @Test
    @DisplayName("Ajout d'un jeu lié à pls genres")
    public void testFindByIDJeuGenres()
    {
        //Arrange
        Genres genres2 = new Genres("aventure");
        Exemplaire exemplaire1 = new Exemplaire("1234567891011",true);
        Jeu jeu1 = new Jeu("test","1234567891011","12","test",8,5,List.of(genres2),List.of(exemplaire1));

        genresRepository.save(genres2);
        jeuRepository.save(jeu1);

        //Act
        Optional<Jeu> jeuOpt = jeuRepository.findById(jeu1.getNo_jeu());

        //Assert
        assertTrue(jeuOpt.isPresent());
        assertEquals(jeu1.getTitre(),jeuOpt.get().getTitre());


        //assertEquals(genres2.getNo_genre(),jeuOpt.get().getGenresList());

    }
}
