package pl.kedzierski.gameshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.kedzierski.gameshop.models.AvailabilityType;
import pl.kedzierski.gameshop.models.Category;
import pl.kedzierski.gameshop.models.Platform;
import pl.kedzierski.gameshop.models.Product;

import java.util.List;

public interface PlatformService {

    Page<Product> getAllProductsbyPlatform(Long id, Pageable pageable);

    Page<Platform> getAllPlatforms(Pageable pageable);

    Platform getPlatform(Long id);

    void deletePlatform(Long id);

    void savePlatform(Platform platform);
}
