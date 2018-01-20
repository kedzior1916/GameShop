package pl.kedzierski.gameshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.kedzierski.gameshop.controllers.commands.ProductFilter;
import pl.kedzierski.gameshop.models.*;

import java.util.List;

public interface ProductService {

    List<AvailabilityType> getAllAvailabilityTypes();

    List<Platform> getAllPlatforms();

    List<Language> getAllLanguages();

    List<Category> getAllCategories();

    Page<Product> getAllProducts(ProductFilter filter, Pageable pageable);

    Product getProduct(Long id);

    void deleteProduct(Long id);

    void saveProduct(Product product);
}
