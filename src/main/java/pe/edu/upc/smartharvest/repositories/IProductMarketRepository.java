package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.ProductMarket;

import java.util.List;

@Repository
public interface IProductMarketRepository extends JpaRepository<ProductMarket, Integer> {
    @Query(value = "SELECT lm.name AS mercado, COUNT(pm.id_product_market) AS total_productos " +
            "FROM product_market pm " +
            "JOIN local_market lm ON pm.id_local_market = lm.id_local_market " +
            "GROUP BY lm.name " +
            "ORDER BY total_productos DESC", nativeQuery = true)
    List<String[]> findTopMarketsByProductCount();
}
