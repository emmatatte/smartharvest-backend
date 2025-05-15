package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.dtos.SensorDTO;
import pe.edu.upc.smartharvest.entities.Sensor;

import java.util.List;

@Repository
public interface ISensorRepository extends JpaRepository<Sensor, Integer> {
    @Query(value = "SELECT * FROM sensor s WHERE s.last_lecture = CURRENT_DATE", nativeQuery = true)
    List<Sensor> getDailySummary();
    List<Sensor> findByBatteryLevelLessThan(double threshold);

    //US34
    @Query(value = "SELECT s.id_sensor, s.sensor_type FROM sensor s WHERE s.state = 'false'", nativeQuery = true)
    public List<String[]> findSensorsWithMaintenance();

    //US38
    @Query(value = "SELECT s.id_sensor, s.sensor_type FROM sensor s WHERE s.last_lecture < CURRENT_DATE",nativeQuery = true)
    public List<String[]> findActiveSensors();
}
