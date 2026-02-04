package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "JEU")
public class Jeu {

    @Id
    @GeneratedValue
    Integer no_jeu;

    @Column(nullable = false,length = 50)
    @NonNull private String titre;

    @Column(nullable = false,length = 13)
    @NonNull private String reference;

    @Column(nullable = false,length = 10)
    @NonNull private String age_min;

    @Column(nullable = false)
    @NonNull private String description;

    @Column(nullable = false, length = 100)
    @NonNull private Integer duree;

    @Column(nullable = false, length = 100)
    @NonNull private Float tarif_jour;

}
