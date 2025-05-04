package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.SatelliteData;
import java.util.List;

public interface ISatelliteDataService {
    List<SatelliteData> list();
    SatelliteData findById(Long id);
    void insert(SatelliteData data);
    void update(SatelliteData data);
    void delete(Long id);
    List<SatelliteData> findByCropId(int cropId);
    List<String[]> findByLatLongRange(double minLat, double maxLat, double minLon, double maxLon);

}