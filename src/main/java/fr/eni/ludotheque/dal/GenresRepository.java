package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepository extends JpaRepository<Genres,Integer> {
}
