package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Cultivo;

import java.util.List;

public interface ICultivoService {
    List<Cultivo> list();
    void insert(Cultivo cultivo);
    void update(Cultivo cultivo);
    void delete(int idCultivo);
}
