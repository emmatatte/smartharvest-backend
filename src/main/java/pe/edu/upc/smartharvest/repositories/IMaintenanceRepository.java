package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Maintenance;

import java.util.List;

@Repository
public interface IMaintenanceRepository extends JpaRepository<Maintenance, Integer> {
    List<Maintenance> findBySensor_IdSensor(int sensorId);

    @Query(value = "SELECT p.name, COUNT(m.*) AS cantidad_mantenimientos\n" +
            "FROM maintenance m\n" +
            "JOIN sensor s ON m.id_sensor = s.id_sensor\n" +
            "JOIN parcel p ON p.id_parcel = s.id_parcel\n" +
            "WHERE p.user_id = :idUser\n" +
            "GROUP BY p.name\n" +
            "ORDER BY COUNT(m.*) DESC", nativeQuery = true)
    List<String[]> findTopParcelsByMaintenanceCount(@Param("idUser") Long idUser);

    List<Maintenance> findMaintenancesBySensor_Parcel_Users_Id(Long sensorParcelUsersId);
}
