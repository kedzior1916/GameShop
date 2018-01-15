package pl.kedzierski.gameshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private LocalDate releaseDate;
    private BigDecimal price;
    private AvailabilityType availability;
    private String description;
    private String requirements;
}
