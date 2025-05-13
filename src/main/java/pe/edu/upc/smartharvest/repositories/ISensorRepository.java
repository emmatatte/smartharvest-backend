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
    @Query("SELECT s FROM Sensor s WHERE s.parcel.idParcel = :parcelId AND s.lastLecture = CURRENT_DATE")
    List<Sensor> getDailySummary(@Param("parcelId") Long parcelId);
    List<Sensor> findByBatteryLevelLessThan(double threshold);

    //US34
    @Query(value = "SELECT s.id_sensor, s.sensor_type FROM sensor s WHERE s.state = 'false'", nativeQuery = true)
    public List<String[]> findSensorsWithMaintenance();

    //US38
    @Query(value = "SELECT s.id_sensor, s.sensor_type FROM sensor s WHERE s.last_lecture < CURRENT_DATE",nativeQuery = true)
    public List<String[]> findActiveSensors();
}
