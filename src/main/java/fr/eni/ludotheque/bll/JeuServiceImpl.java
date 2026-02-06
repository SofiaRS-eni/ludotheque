package fr.eni.ludotheque.bll;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.dal.JeuRepository;
import org.springframework.stereotype.Service;

@Service
public class JeuServiceImpl implements JeuService {

    private JeuRepository jeuRepository;

    public JeuServiceImpl(JeuRepository jeuRepository) {
        this.jeuRepository = jeuRepository;
    }

    @Override
    public Jeu creerJeu(Jeu jeu)
    {
        return jeuRepository.save(jeu);
    }
}
