package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Maintenance;
import pe.edu.upc.smartharvest.repositories.IMaintenanceRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IMaintenanceService;

import java.util.List;

@Service
public class MaintenanceServiceImplement implements IMaintenanceService {
    @Autowired
    private IMaintenanceRepository mR;

    @Override
    public List<Maintenance> list(){
        return mR.findAll();
    }

    @Override
    public void insert(Maintenance m) {
        mR.save(m);
    }

    @Override
    public void update(Maintenance m) {
        mR.save(m);
    }

    @Override
    public void delete(int idMantenimiento) {
        mR.deleteById(idMantenimiento);
    }

    @Override
    public List<Maintenance> findBySensorId(int sensorId) {
        return mR.findBySensor_IdSensor(sensorId);
    }

    @Override
    public List<String[]> findTopParcelsByMaintenanceCount(Long idUser) {
        return mR.findTopParcelsByMaintenanceCount(idUser);
    }

    @Override
    public Maintenance listId(int idMaintenance) {
        return mR.findById(idMaintenance).orElse(new Maintenance());
    }

    @Override
    public List<Maintenance> findMaintenancesBySensor_Parcel_Users_Id(Long sensorParcelUsersId) {
        return mR.findMaintenancesBySensor_Parcel_Users_Id(sensorParcelUsersId);
    }
}
