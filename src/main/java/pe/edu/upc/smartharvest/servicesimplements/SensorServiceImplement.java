package pe.edu.upc.smartharvest.servicesimplements;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.dtos.SensorDTO;
import pe.edu.upc.smartharvest.entities.Sensor;
import pe.edu.upc.smartharvest.repositories.ISensorRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.ISensorService;

import java.util.List;
import java.util.stream.Collectors;

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
    public Sensor listId(int idSensor) {
        return sR.findById(idSensor).orElse(null); // Retorna Sensor o null
    }

    @Override
    public List<SensorDTO> getDailySummary() {
        List<Sensor> sensors = sR.getDailySummary();
        ModelMapper mapper = new ModelMapper();
        return sensors.stream()
                .map(sensor -> mapper.map(sensor, SensorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Sensor> findByBatteryLevelLessThan(double threshold) {
        return sR.findByBatteryLevelLessThan(threshold);
    }

    @Override
    public List<String[]> findSensorsWithMaintenance(){
        return sR.findSensorsWithMaintenance();
    }

    @Override
    public List<String[]> FindActiveSensors(){
        return sR.findActiveSensors();
    }
}
