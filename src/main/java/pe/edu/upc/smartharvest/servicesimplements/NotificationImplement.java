package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Notification;
import pe.edu.upc.smartharvest.entities.Users;
import pe.edu.upc.smartharvest.repositories.INotificationRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.INotificationService;
import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationImplement implements INotificationService {

    @Autowired
    private INotificationRepository nR;

    @Override
    public List<Notification> list() {
        return nR.findAll();
    }

    @Override
    public void insert(Notification notification) {
        nR.save(notification);
    }

    @Override
    public void update(Notification notification) {
        nR.save(notification);
    }

    @Override
    public void delete(int idNotification) {
        nR.deleteById(idNotification);
    }

    @Override
    public List<Notification> findByNotificationType(String notificationType) {
        return nR.findByNotificationType(notificationType);
    }

    @Override
    public List<String[]> countNotificationsByMonthInYear(int year) {
        return nR.countNotificationsByMonthInYear(year);
    }

    public void createWeatherNotification(Users user, String weatherEvent, String message) {
        Notification notification = new Notification();
        notification.setUsers(user);
        notification.setNotificationType("weather");
        notification.setWeatherEvent(weatherEvent);
        notification.setMessage(message);
        notification.setDateTime(LocalDate.now());
        notification.setRead(false);
        nR.save(notification);
    }
}