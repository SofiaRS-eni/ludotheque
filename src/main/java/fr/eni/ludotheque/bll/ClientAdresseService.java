package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Client;

import java.util.Optional;

public interface ClientAdresseService {
    Client creerClient(Client client);

    Optional<Client> getClientById(Integer id);
    Client modifClient(Integer id ,Client client);
}
