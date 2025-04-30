package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Sensor;

public interface ISensorRepository extends JpaRepository<Sensor, Integer> {
  @Query("SELECT s FROM Sensor s WHERE s.parcel.idParcel = :parcelId AND s.lastLecture BETWEEN :start AND :end")
    List<Sensor> findSatelliteDataByParcelAndDate(
        @Param("parcelId") Long parcelId,
        @Param("start") LocalDate start,
        @Param("end") LocalDate end
    );
}
