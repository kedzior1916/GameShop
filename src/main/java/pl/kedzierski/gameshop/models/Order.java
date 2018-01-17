package pl.kedzierski.gameshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Order {
    private Long id;
    private LocalDate orderDate;
    private User user;
    private BigDecimal overallCost;
}
