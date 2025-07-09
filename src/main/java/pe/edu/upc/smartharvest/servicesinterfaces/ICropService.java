package pe.edu.upc.smartharvest.servicesinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.smartharvest.entities.Company;
import pe.edu.upc.smartharvest.entities.Crop;

import java.time.LocalDate;
import java.util.List;

public interface ICropService {
    List<Crop> list();
    void insert(Crop crop);
    void update(Crop crop);
    void delete(int idCrop);
    Crop listId(int idCrop);
    List<Crop> findByTypeCrop(String typeCrop);
    List<String[]> findCropsNeedingAttention();
    List<String[]> CropsByActualState();
    List<String[]> findActiveCrops();
    List<String[]> countHarvestByCropTypeInRange(LocalDate startDate, LocalDate endDate);
    List<Crop> findCropsByParcel_Users_Id(Long parcelUsersId);
}
