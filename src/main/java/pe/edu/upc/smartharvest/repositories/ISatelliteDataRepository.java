package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.SatelliteData;
import java.util.List;

@Repository
public interface ISatelliteDataRepository extends JpaRepository<SatelliteData, Long> {
    List<SatelliteData> findByCropIdOrderByCaptureDateDesc(int cropId);
    @Query("SELECT s FROM SatelliteData s WHERE s.latitude BETWEEN :minLat AND :maxLat AND s.longitude BETWEEN :minLon AND :maxLon")
    List<SatelliteData> findByLatLongRange(@Param("minLat") double minLat,
                                           @Param("maxLat") double maxLat,
                                           @Param("minLon") double minLon,
                                           @Param("maxLon") double maxLon);
}