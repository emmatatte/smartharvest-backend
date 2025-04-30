package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Sensor;
import pe.edu.upc.smartharvest.repositories.ISensorRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.ISensorService;

import java.util.List;

@Service
public class SensorServiceImplement implements ISensorService {
    @Autowired
    private ISensorRepository sR;

    @Override
    public List<Sensor> list() {
        return sR.findAll();
    }

    @Override
    public void insert(Sensor sensor) {
        sR.save(sensor);
    }

    @Override
    public void update(Sensor sensor) {
        sR.save(sensor);
    }

    @Override
    public void delete(int idSensor) {
        sR.deleteById(idSensor);
    }

    @Override
    public List<SensorDTO> getSatelliteData(Long parcelId, LocalDate startDate, LocalDate endDate) {
        List<Sensor> sensors = sensorRepository.findSatelliteDataByParcelAndDate(parcelId, startDate, endDate);
        ModelMapper mapper = new ModelMapper();
        return sensors.stream()
                .map(sensor -> mapper.map(sensor, SensorDTO.class))
                .collect(Collectors.toList());
    }
}
