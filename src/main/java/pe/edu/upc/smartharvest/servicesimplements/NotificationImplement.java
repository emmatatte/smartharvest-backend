package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Notification;
import pe.edu.upc.smartharvest.repositories.INotificationRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.INotificationService;
import pe.edu.upc.smartharvest.servicesinterfaces.IRecommendationService;

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
}
