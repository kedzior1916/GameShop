package pl.kedzierski.gameshop.models;

import lombok.*;
import org.hibernate.annotations.Tables;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @NotBlank
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
    private AvailabilityType availability;
    @Lob
    private String description;
    @Lob
    private String requirements;
    @JoinColumn(name="category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;
    @JoinColumn(name="platform_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Platform platform;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Language> languages;
    private String imageName;
}
