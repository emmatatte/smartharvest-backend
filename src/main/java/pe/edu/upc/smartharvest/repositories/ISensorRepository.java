package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Sensor;

public interface ISensorRepository extends JpaRepository<Sensor, Integer> {
}
