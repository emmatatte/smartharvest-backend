package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.LocalMarket;

import java.util.List;

@Repository
public interface ILocalMarketRepository extends JpaRepository<LocalMarket, Integer> {
    List<LocalMarket> findByLocationContainingIgnoreCase(String location);

    List<LocalMarket> findLocalMarketsByUsers_Id(Long usersId);
}
