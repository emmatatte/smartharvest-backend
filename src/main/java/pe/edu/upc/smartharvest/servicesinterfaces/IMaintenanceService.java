package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    List<Maintenance> list();
    void insert(Maintenance maintenance);
    void update(Maintenance maintenance);
    void delete(int idMaintenance);
    List<Maintenance> findBySensorId(int sensorId);
    List<Object[]> findTopCropsByMaintenanceCount();
}
