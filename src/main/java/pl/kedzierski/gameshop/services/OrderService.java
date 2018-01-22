package pl.kedzierski.gameshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.kedzierski.gameshop.models.Order;
import pl.kedzierski.gameshop.models.Platform;
import pl.kedzierski.gameshop.models.Product;

public interface OrderService {
    Page<Order> getAllOrdersByActiveUser(Pageable pageable);

    Page<Order> getAllOrders(Pageable pageable);

    Order getOrder(Long id);

    void deleteOrder(Long id);
}
