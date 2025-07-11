package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.LocalMarket;
import pe.edu.upc.smartharvest.entities.Parcel;

import java.util.List;

public interface IParcelService {
    List<Parcel> list();
    void insert(Parcel parcel);
    void update(Parcel parcel);
    void delete(int idParcel);
    List<Parcel> findByUserId(Long userId);
    public Parcel listId(int idParcel);
    List<String[]> findActiveParcels();
    List<String[]> countParcelsByMonthInYear(int year);
}
