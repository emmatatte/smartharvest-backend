package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Sensor;

public interface ISensorRepository extends JpaRepository<Sensor, Integer> {
  @Query("SELECT s FROM Sensor s WHERE s.parcel.id = :parcelId AND s.date BETWEEN :startDate AND :endDate")
      List<Sensor> getSatelliteDataByParcel(
        @Param("parcelId") Long parcelId,
        @Param("startDate") LocalDate startDate,
        @Param("endDate") LocalDate endDate
    );
}
