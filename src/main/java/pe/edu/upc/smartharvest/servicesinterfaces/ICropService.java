package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Company;
import pe.edu.upc.smartharvest.entities.Crop;

import java.util.List;

public interface ICropService {
    List<Crop> list();
    void insert(Crop crop);
    void update(Crop crop);
    void delete(int idCrop);
    public Crop listId(int idCrop);
    List<Crop> findByTypeCrop(String typeCrop);
    List<Crop> findByActualState(String actualState);
    public List<String[]> findCropsNeedingAttention();
    public List<String[]> identifyUpcomingCropDays();
    public List<String[]> findActiveCrops();
}
