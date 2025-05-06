package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Maintenance;

import java.util.List;

@Repository
public interface IMaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    List<Maintenance> findBySensor_IdSensor(int sensorId);
    @Query("SELECT s.crop.typeCrop, COUNT(m) FROM Maintenance m JOIN m.sensor s GROUP BY s.crop.typeCrop ORDER BY COUNT(m) DESC")
    List<Object[]> findTopCropsByMaintenanceCount();
}
