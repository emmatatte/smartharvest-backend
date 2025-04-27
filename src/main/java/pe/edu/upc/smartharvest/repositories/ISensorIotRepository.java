package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.SensorIot;

public interface ISensorIotRepository extends JpaRepository<SensorIot, Integer> {
}
