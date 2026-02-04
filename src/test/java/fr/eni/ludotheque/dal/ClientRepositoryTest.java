package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;
    private AdresseRepository adresseRepository;

    @Test
    @DisplayName("Trouver un client connassaint son id")
    public void testFindByIdClient()
    {
        //Arrange
        Adresse adresse1 = new Adresse("25","rue de Limoges","7900","Niort");
        Client client1 = new Client("Tata","Toto","tata@mail.com",adresse1);

        clientRepository.save(client1);


        //Act
        Optional<Client> clientOpt = clientRepository.findById(client1.getId());

        //Assert
        assertTrue(clientOpt.isPresent());
        assertEquals(client1.getPrenom(),clientOpt.get().getPrenom());
        assertEquals(client1.getNom(),clientOpt.get().getNom());
        assertEquals(client1.getEmail(),clientOpt.get().getEmail());

        assertEquals(clientOpt.get().getId(),adresse1.getId());

        //clientRepository.deleteById(client1.getId());

    }

}
