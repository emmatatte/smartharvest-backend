package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Parcela;

import java.util.List;

public interface IParcelaService {
    List<Parcela> list();
    void insert(Parcela parcela);
    void update(Parcela parcela);
    void delete(int idParcela);
}
