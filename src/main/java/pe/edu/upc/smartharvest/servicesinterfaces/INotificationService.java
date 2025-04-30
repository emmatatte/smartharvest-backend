package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Notification;

import java.util.List;

public interface INotificationService {
    List<Notification> list();
    void insert(Notification notification);
    void update(Notification notification);
    void delete(int idNotification);
}
