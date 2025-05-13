package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.dtos.SensorDTO;
import pe.edu.upc.smartharvest.entities.Sensor;

import java.util.Arrays;
import java.util.List;

public interface ISensorService {
    List<Sensor> list();
    void insert(Sensor sensor);
    void update(Sensor sensor);
    void delete(int idSensor);
    Sensor listId(int idSensor);
    List<SensorDTO> getDailySummary(Long parcelId);
    List<Sensor> findByBatteryLevelLessThan(double threshold);

    public List<String[]> findSensorsWithMaintenance();

    public List<String[]> FindActiveSensors();
}
