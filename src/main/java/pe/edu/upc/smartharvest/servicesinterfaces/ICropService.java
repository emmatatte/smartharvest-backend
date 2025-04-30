package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Crop;

import java.util.List;

public interface ICropService {
    List<Crop> list();
    void insert(Crop crop);
    void update(Crop crop);
    void delete(int idCrop);
}
