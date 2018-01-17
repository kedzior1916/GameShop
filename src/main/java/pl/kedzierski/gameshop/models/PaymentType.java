package pl.kedzierski.gameshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentType {
    private Long id;
    private String name;
}
