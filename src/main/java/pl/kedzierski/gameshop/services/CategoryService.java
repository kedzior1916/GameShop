package pl.kedzierski.gameshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.kedzierski.gameshop.controllers.commands.ProductFilter;
import pl.kedzierski.gameshop.models.*;

import java.util.List;

public interface CategoryService {

    Page<Product> getAllProductsbyCategory(Long id, Pageable pageable);

    Page<Category> getAllCategories(Pageable pageable);

    Category getCategory(Long id);

    void deleteCategory(Long id);

    void saveCategory(Category category);
}
