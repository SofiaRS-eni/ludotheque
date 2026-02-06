package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Client;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    //SQL nativeQuery
    @Query(value = "select * from client where nom like :prefix%",nativeQuery = true)

        List<Client> findCLientByNom(@Param("prefix") String prefix);

}
