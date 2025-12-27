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

    List<Sensor> findSensorsByParcel_Users_Id(Long parcelUsersId);
    //US34
    @Query(value = "SELECT s.id_sensor, s.sensor_type FROM sensor s WHERE s.state = 'false'", nativeQuery = true)
    public List<String[]> findSensorsWithMaintenance();

    //US38
    @Query(value = "SELECT s.id_sensor, s.sensor_type FROM sensor s WHERE s.last_lecture < CURRENT_DATE",nativeQuery = true)
    public List<String[]> findActiveSensors();

    @Query(value = "SELECT s.sensor_type,\n" +
            "COUNT(*) AS cantidad\n" +
            "FROM sensor s\n" +
            "JOIN parcel p ON s.id_parcel = p.id_parcel\n" +
            "WHERE s.state = true AND p.user_id = :idUser\n" +
            "GROUP BY s.sensor_type\n" +
            "ORDER BY cantidad DESC",nativeQuery = true)
    List<String[]> countActiveSensorsByType(@Param("idUser") Long idUser);

    @Query(value = "SELECT s.sensor_type,\n" +
            "COUNT(*) AS cantidad\n" +
            "FROM maintenance m\n" +
            "JOIN sensor s ON m.id_sensor = s.id_sensor\n" +
            "JOIN parcel p ON p.id_parcel = s.id_parcel\n" +
            "WHERE p.user_id = :idUser\n" +
            "GROUP BY s.sensor_type\n" +
            "ORDER BY cantidad DESC",nativeQuery = true)
    List<String[]> countMaintenanceBySensorType(@Param("idUser") Long idUser);
}
