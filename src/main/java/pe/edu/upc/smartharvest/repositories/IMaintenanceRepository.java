package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Maintenance;

import java.util.List;

@Repository
public interface IMaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    List<Maintenance> findBySensor_IdSensor(int sensorId); // US28
}
