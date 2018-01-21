package pl.kedzierski.gameshop.models;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Tables;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Length(min = 1)
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name="release_date")
    private Date releaseDate;
    @Min(0)
    @Max(1000000)
    private BigDecimal price;
    @JoinColumn(name="availabilitytype_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private AvailabilityType availability;
    @Lob
    @Type(type = "text")
    private String description;
    @Lob
    @Type(type = "text")
    private String requirements;
    @JoinColumn(name="category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;
    @JoinColumn(name="platform_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Platform platform;
    @ManyToMany(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Language> languages;
    private String imageName;
}
