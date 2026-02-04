package fr.eni.ludotheque.bo;


import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "CLIENT")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false, length = 100)
    @NonNull
    private String nom;

    @Column(nullable = false, length = 100)
    @NonNull private String prenom;

    @Column(nullable = false, length = 100)
    @NonNull private String email;

    @Column(nullable = true, length = 10)
    private String telephone;

    @OneToOne(cascade = CascadeType.PERSIST)
    @NonNull Adresse adresse;

}
