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
    @Query(value = "SELECT c.type_crop, COUNT(m.*) AS cantidad_mantenimientos\n" +
            "               FROM maintenance m\n" +
            "               JOIN sensor s ON m.id_sensor = s.id_sensor\n" +
            "               JOIN crop c ON s.id_crop = c.id_crop\n" +
            "               GROUP BY c.type_crop\n" +
            "               ORDER BY COUNT(m.*) DESC", nativeQuery = true)
    List<String[]> findTopCropsByMaintenanceCountGroupByType();
}
