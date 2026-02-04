package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Adresse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {
}
