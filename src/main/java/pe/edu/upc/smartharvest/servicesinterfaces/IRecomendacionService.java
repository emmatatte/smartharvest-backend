package pe.edu.upc.smartharvest.servicesinterfaces;


import pe.edu.upc.smartharvest.entities.Recomendacion;

import java.util.List;

public interface IRecomendacionService {
    List<Recomendacion> list();
    void insert(Recomendacion r);
    void update(Recomendacion r);
    void delete(int idRecomendation);
}
