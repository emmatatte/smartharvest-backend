package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Sensor;

import java.util.List;

public interface ISensorService {
    List<Sensor> list();
    void insert(Sensor sensor);
    void update(Sensor sensor);
    void delete(int idSensor);
}
