package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.LocalMarket;

public interface ILocalMarketRepository extends JpaRepository<LocalMarket, Integer> {

}
