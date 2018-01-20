package pl.kedzierski.gameshop.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="platforms")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Platform {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
}
