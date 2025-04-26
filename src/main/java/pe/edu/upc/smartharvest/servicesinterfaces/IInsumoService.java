package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Insumo;

import java.util.List;

public interface IInsumoService {
    List<Insumo> list();
    void insert(Insumo insumo);
    void update(Insumo insumo);
    void delete(int idInsumo);
}
