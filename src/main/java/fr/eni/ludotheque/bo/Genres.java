package fr.eni.ludotheque.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "GENRES")
public class Genres {

}
