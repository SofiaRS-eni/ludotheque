package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "EXEMPLAIRE")
public class Exemplaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer no_exemplaire;

    @Column(nullable = false,length = 13)
    @NonNull private String codebarre;

    @Column(nullable = false)
    @NonNull private Boolean louable;


    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE})
    private Jeu jeu;
}
