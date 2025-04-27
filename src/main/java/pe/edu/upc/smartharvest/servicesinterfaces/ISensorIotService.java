package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.SensorIot;

import java.util.List;

public interface ISensorIotService {
    List<SensorIot> list();
    void insert(SensorIot s);
    void update(SensorIot s);
    void delete(int idSensor);
}
