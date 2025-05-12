package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Notificacion;

import java.util.List;

public interface INotificacionService {
    List<Notificacion> list();
    void insert(Notificacion n);
    void update(Notificacion n);
    void delete(int idNotificacion);
}
