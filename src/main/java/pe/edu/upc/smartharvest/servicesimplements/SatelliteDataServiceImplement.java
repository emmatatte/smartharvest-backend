package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.SatelliteData;
import pe.edu.upc.smartharvest.repositories.ISatelliteDataRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.ISatelliteDataService;
import java.util.List;
import java.util.Optional;

@Service
public class SatelliteDataServiceImplement implements ISatelliteDataService {

    @Autowired
    private ISatelliteDataRepository repo;

    @Override
    public List<SatelliteData> list() {
        return repo.findAll();
    }

    @Override
    public SatelliteData findById(Long id) {
        Optional<SatelliteData> data = repo.findById(id);
        return data.orElse(null);
    }

    @Override
    public void insert(SatelliteData data) {
        repo.save(data);
    }

    @Override
    public void update(SatelliteData data) {
        repo.save(data);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<SatelliteData> findByCropId(int cropId) {
        return repo.findByCropIdOrderByCaptureDateDesc(cropId);
    }

    @Override
    public List<SatelliteData> findByLatLongRange(double minLat, double maxLat, double minLon, double maxLon) {
        return repo.findByLatLongRange(minLat, maxLat, minLon, maxLon);
    }

}