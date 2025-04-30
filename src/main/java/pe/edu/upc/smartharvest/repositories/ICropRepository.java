package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Crop;

public interface ICropRepository extends JpaRepository<Crop, Integer> {
}
