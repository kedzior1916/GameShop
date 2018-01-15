package pl.kedzierski.gameshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AvailabilityType {
    private long id;
    private String name;
    private Boolean inStock;
}
