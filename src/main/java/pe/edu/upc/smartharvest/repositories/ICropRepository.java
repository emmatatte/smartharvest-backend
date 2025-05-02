package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Crop;

import java.util.List;

@Repository
public interface ICropRepository extends JpaRepository<Crop, Integer> {
    List<Crop> findByTypeCrop(String typeCrop); // US27
    List<Crop> findByActualState(String actualState); // US27
}
