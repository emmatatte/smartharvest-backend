package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.MercadoLocal;

import java.util.List;

public interface IMercadoLocalService {
    List<MercadoLocal> list();
    void insert(MercadoLocal m);
    void update(MercadoLocal m);
    void delete(int idMercadoLocal);
}
