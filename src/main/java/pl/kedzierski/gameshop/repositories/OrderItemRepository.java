package pl.kedzierski.gameshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kedzierski.gameshop.models.Order;
import pl.kedzierski.gameshop.models.OrderItem;
import pl.kedzierski.gameshop.models.User;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
