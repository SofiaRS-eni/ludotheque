package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;

import java.util.List;
import java.util.Optional;

public interface ClientAdresseService {
    Client creerClient(Client client);
    List<Client> getClientByNom(String prefix);
    Optional<Client> getClientById(Integer id);
    Client modifClient(Integer id ,Client client);
    Adresse modifAdresseClient(Integer id, Adresse adresse);
}
