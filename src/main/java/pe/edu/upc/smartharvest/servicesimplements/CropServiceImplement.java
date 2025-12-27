package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Crop;
import pe.edu.upc.smartharvest.repositories.ICropRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.ICropService;

import java.time.LocalDate;
import java.util.List;

@Service
public class CropServiceImplement implements ICropService {
    @Autowired
    private ICropRepository cR;

    @Override
    public List<Crop> list() {
        return cR.findAll();
    }

    @Override
    public void insert(Crop cultivo) {
        cR.save(cultivo);
    }

    @Override
    public void update(Crop cultivo) {
        cR.save(cultivo);
    }

    @Override
    public void delete(int idCultivo) {
        cR.deleteById(idCultivo);
    }

    @Override
    public Crop listId(int idCrop) {
        return cR.findById(idCrop).orElse(new Crop());
    }

    @Override
    public List<Crop> findByTypeCrop(String typeCrop) {
        return cR.findByTypeCrop(typeCrop);
    }

    @Override
    public List<String[]> findCropsNeedingAttention(Long idUser) { return cR.findCropsNeedingAttention(idUser);}

    @Override
    public List<String[]> findCropRiskPercentageByParcel(Long idUser) {
        return cR.findCropRiskPercentageByParcel(idUser);
    }

    @Override
    public List<String[]> CropsByActualState(Long idUser) {
        return cR.CropsByActualState(idUser);
    }

    @Override
    public List<String[]> findActiveCrops() {
        return cR.findActiveCrops();
    }

    @Override
    public List<String[]> countHarvestByCropTypeInRange(LocalDate startDate, LocalDate endDate, Long idUser) {
        return cR.countHarvestByCropTypeInRange(startDate, endDate, idUser);
    }

    @Override
    public List<Crop> findCropsByParcel_Users_Id(Long parcelUsersId) {
        return cR.findCropsByParcel_Users_Id(parcelUsersId);
    }
}


