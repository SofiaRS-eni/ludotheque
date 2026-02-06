package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.dal.AdresseRepository;
import fr.eni.ludotheque.dal.ClientRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientAdresseServiceImpl implements ClientAdresseService {
    private ClientRepository clientRepository;
    private AdresseRepository adresseRepository;

    public  ClientAdresseServiceImpl(ClientRepository clientRepository, AdresseRepository adresseRepository)
    {
        this.adresseRepository=adresseRepository;
        this.clientRepository=clientRepository;
    }

    @Override
    @Transactional
    public Client creerClient(Client client)
    {
        try {
            clientRepository.save(client);
        }
        catch (Exception e)
        {
            throw  e;
        }
        return client;
    }

    @Override
    public Optional<Client> getClientById(Integer id) {

        return clientRepository.findById(id);
    }

    @Override
    public Client modifClient(Integer id, Client client)
    {
        Client clientId = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        if (clientId!=null)
        {
            //Modif Client
            clientId.setNom(client.getNom());
            clientId.setPrenom(client.getPrenom());
            clientId.setEmail(client.getEmail());

            //Adresse
            Adresse clientAdresse = clientId.getAdresse();
            clientAdresse.setNo_adresse(clientId.getAdresse().getNo_adresse());
            clientAdresse.setRue(clientId.getAdresse().getRue());
            clientAdresse.setCode_postal(clientId.getAdresse().getCode_postal());
            clientAdresse.setVille(clientId.getAdresse().getVille());

        }
        return clientRepository.save(client);
    }

    @Override
    public Adresse modifAdresseClient(Integer id,Adresse adresse) {
        Client clientId = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));


        Adresse adresseID = clientId.getAdresse();
        adresseID.setNo_adresse(adresse.getNo_adresse());
        adresseID.setRue(adresse.getRue());
        adresseID.setCode_postal(adresse.getCode_postal());
        adresseID.setVille(adresse.getVille());
        return adresseRepository.save(adresseID);


    }

    @Override
    public List<Client> getClientByNom(String prefix)
    {
        return clientRepository.findCLientByNom(prefix);
    }
}
