package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Parcel;
import pe.edu.upc.smartharvest.repositories.IParcelRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IParcelService;

import java.util.List;

@Service
public class ParcelServiceImplement implements IParcelService {
    @Autowired
    private IParcelRepository pR;

    @Override
    public List<Parcel> list() {
        return pR.findAll();
    }

    @Override
    public void insert(Parcel parcel) {
        pR.save(parcel);
    }

    @Override
    public void update(Parcel parcel) {
        pR.save(parcel);
    }

    @Override
    public void delete(int idParcela) {
        pR.deleteById(idParcela);
    }

    @Override
    public List<Parcel> findByUserId(Long userId) {
        return pR.findParcelByUsers_Id(userId);
    }

    @Override
    public Parcel listId(int idParcel) {
        return pR.findById(idParcel).orElse(new Parcel());
    }

    @Override
    public List<String[]> findActiveParcels() {
        return pR.findActiveParcels();
    }

    @Override
    public List<String[]> countParcelsByMonthInYear(int year) {
        return pR.countParcelsByMonthInYear(year);
    }

}
