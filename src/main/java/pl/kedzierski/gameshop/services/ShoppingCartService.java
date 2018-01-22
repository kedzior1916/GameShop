package pl.kedzierski.gameshop.services;

import pl.kedzierski.gameshop.models.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout();

    BigDecimal getTotal();

    void sendConfirmation(String to, String subject, String text);
}
