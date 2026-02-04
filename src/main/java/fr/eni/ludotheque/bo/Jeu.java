package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "JEU")
public class Jeu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer no_jeu;

    @Column(nullable = false,length = 50)
    @NonNull private String titre;

    @Column(nullable = false,length = 13)
    @NonNull private String reference;

    @Column(nullable = false)
    @NonNull private String age_min;

    @Column(nullable = false)
    @NonNull private String description;

    @Column(nullable = false, length = 100)
    @NonNull private Integer duree;

    @Column(nullable = false, length = 100)
    @NonNull private Integer tarif_jour;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},
    fetch = FetchType.EAGER)
    @JoinTable(name = "JeuGenres",
            joinColumns = {@JoinColumn(name = "jeu_id")},
            inverseJoinColumns = {@JoinColumn(name = "genres_id")}
    )
    @NonNull List<Genres> genresList;

    @OneToMany(cascade = CascadeType.ALL,
            fetch=FetchType.EAGER,
            orphanRemoval=true,
            mappedBy="jeu")
    private List<Exemplaire> exemplaires;
}
