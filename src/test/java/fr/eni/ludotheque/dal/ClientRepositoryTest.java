package fr.eni.ludotheque.dal;

import fr.eni.ludotheque.bll.ClientAdresseService;
import fr.eni.ludotheque.bll.ClientAdresseServiceImpl;
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
    @Autowired
    private AdresseRepository adresseRepository;
    @Autowired
    private ClientAdresseService clientAdresseService;

    @Test
    @DisplayName("Trouver un client connassaint son id")
    public void testFindByIdClient()
    {
        //Arrange
        Adresse adresse1 = new Adresse("25","rue de Limoges","7900","Niort");
        Client client1 = new Client("Tata","Toto","tata@mail.com",adresse1);

        //clientRepository.save(client1);
        clientAdresseService.creerClient(client1);



        //Act
        //Optional<Client> clientOpt = clientRepository.findById(client1.getId());
        Optional<Client> clientOpt = clientAdresseService.getClientById(client1.getId());

        //Assert

        assertTrue(clientOpt.isPresent());
        assertEquals(client1.getPrenom(),clientOpt.get().getPrenom());
        assertEquals(client1.getNom(),clientOpt.get().getNom());
        assertEquals(client1.getEmail(),clientOpt.get().getEmail());

        assertEquals(clientOpt.get().getId(),adresse1.getId());

        //clientRepository.deleteById(client1.getId());



    }

    @Test
    @DisplayName("Modifier un client et son adresse")
    public void testModifClient()
    {
        //Arrange
        Adresse adresse1 = new Adresse("25","rue de Limoges","7900","Niort");
        Client client1 = new Client("Tata","Toto","tata@mail.com",adresse1);


        Client client2 = new Client("Tata","Toto","tata@mail.com",adresse1);

        Adresse newAdresse = new Adresse("10","rue de Paris","7900","Niort");
        Client newClient = new Client("Titi","Toto","titi@mail.com",newAdresse);

        //clientRepository.save(client1);
        Client client = clientAdresseService.creerClient(client1);



        //Act
        //Optional<Client> clientOpt = clientRepository.findById(client1.getId());
        Optional<Client> clientOpt = clientAdresseService.getClientById(client.getId());

        //Cas positif
        clientAdresseService.modifClient(client1.getId(),newClient);

        //Cas negatif
        //clientAdresseService.modifClient(client2.getId(),newClient);
        //Assert

        assertTrue(clientOpt.isPresent());
        assertEquals(client1.getPrenom(),clientOpt.get().getPrenom());
        assertEquals(client1.getNom(),clientOpt.get().getNom());
        assertEquals(client1.getEmail(),clientOpt.get().getEmail());

        assertEquals(clientOpt.get().getId(),adresse1.getId());

        //clientRepository.deleteById(client1.getId());
    }

    @Test
    @DisplayName("Modifier l'adresse d'un client")
    public void testModifAdresseClient()
    {
        //Arrange
        Adresse adresse1 = new Adresse("25","rue de Limoges","7900","Niort");
        Client client1 = new Client("Tata","Toto","tata@mail.com",adresse1);

        Adresse newAdresse = new Adresse("10","rue de Paris","7900","Niort");


        //clientRepository.save(client1);
        Client client = clientAdresseService.creerClient(client1);



        //Act
        Optional<Client> clientOpt = clientAdresseService.getClientById(client.getId());


        clientAdresseService.modifAdresseClient(client.getId(),newAdresse);

        //Assert



       //clientRepository.deleteById(client1.getId());
  }

    @Test
    @DisplayName("trouver les clients dont le nom commence par la chaine fournie")
    public void testGetClientByNom()
    {
        //Arrange
        Adresse adresse1 = new Adresse("25","rue de Limoges","7900","Niort");
        Client client1 = new Client("Tata","Toto","tata@mail.com",adresse1);


        //clientRepository.save(client1);
        Client client = clientAdresseService.creerClient(client1);



        //Act
        Optional<Client> clientOpt = clientAdresseService.getClientById(client.getId());


        clientAdresseService.getClientByNom("T");

        //Assert



        //clientRepository.deleteById(client1.getId());
    }
}
