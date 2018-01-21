package pl.kedzierski.gameshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.kedzierski.gameshop.models.AvailabilityType;
import pl.kedzierski.gameshop.models.Category;
import pl.kedzierski.gameshop.models.Product;

public interface AvailabilityService {

    Page<AvailabilityType> getAllTypes(Pageable pageable);

    AvailabilityType getType(Long id);

    void deleteType(Long id);

    void saveType(AvailabilityType type);
}
