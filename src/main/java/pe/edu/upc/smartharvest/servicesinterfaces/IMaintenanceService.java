package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Input;
import pe.edu.upc.smartharvest.entities.Maintenance;

import java.util.List;

public interface IMaintenanceService {
    List<Maintenance> list();
    void insert(Maintenance maintenance);
    void update(Maintenance maintenance);
    void delete(int idMaintenance);
    List<Maintenance> findBySensorId(int sensorId);
    List<String[]> findTopParcelsByMaintenanceCount(Long idUser);
    Maintenance listId(int idMaintenance);
    List<Maintenance> findMaintenancesBySensor_Parcel_Users_Id(Long sensorParcelUsersId);
}
