package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Genres;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class GenresRepositoryTest {

    @Autowired
    private GenresRepository genresRepository ;

    @Test
    @DisplayName("Trouver un genres connaissant son id")
    public void testFindByIdGenres()
    {
        //Arrange
        Genres genres1 = new Genres("fantasy");

        genresRepository.save(genres1);

        //Act
        Optional<Genres> genresOpt = genresRepository.findById(genres1.getNo_genre());

        //Assert
        assertTrue(genresOpt.isPresent());
        assertEquals(genres1.getLibelle(),genresOpt.get().getLibelle());
    }

}
