package pl.kedzierski.gameshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kedzierski.gameshop.models.Order;
import pl.kedzierski.gameshop.models.Product;
import pl.kedzierski.gameshop.models.User;

import java.math.BigDecimal;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o FROM Order o WHERE o.user.id = :id")
    Page<Order> findAllByUserId(@Param("id") Long id, Pageable pageable);

}
