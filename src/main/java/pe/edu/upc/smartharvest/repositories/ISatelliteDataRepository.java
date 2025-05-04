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
    @Query(value = "SELECT s FROM satellite_data s WHERE s.latitude BETWEEN :minLat AND :maxLat AND s.longitude BETWEEN :minLon AND :maxLon", nativeQuery = true)
    List<String[]> findByLatLongRange(@Param("minLat") double minLat, // US14
                                           @Param("maxLat") double maxLat,
                                           @Param("minLon") double minLon,
                                           @Param("maxLon") double maxLon);
}