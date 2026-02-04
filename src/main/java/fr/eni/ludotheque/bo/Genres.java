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
@Table(name = "GENRES")
public class Genres {
    @Id
    @GeneratedValue
    Integer no_genre;

    @Column(nullable = false,length = 50)
    @NonNull private String libelle;

}
