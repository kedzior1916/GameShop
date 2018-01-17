package pl.kedzierski.gameshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.kedzierski.gameshop.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
}
