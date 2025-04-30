package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Notification;
@Repository
public interface INotificationRepository extends JpaRepository<Notification, Integer> {
}
