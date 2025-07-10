package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Input;
import pe.edu.upc.smartharvest.entities.Notification;

import java.util.List;

public interface INotificationService {
    List<Notification> list();
    void insert(Notification notification);
    void update(Notification notification);
    void delete(int idNotification);
    List<Notification> findByNotificationType(String notificationType);
    List<String[]> countNotificationsByMonthInYear(int year);
    public List<Notification> listIdUser(Long idUser);
}
