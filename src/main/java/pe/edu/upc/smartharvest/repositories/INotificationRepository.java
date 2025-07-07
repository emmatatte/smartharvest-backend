package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Notification;

import java.util.List;

@Repository
public interface INotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByNotificationType(String notificationType);

    @Query(value = "SELECT \n" +
            "        TO_CHAR(n.date_time, 'YYYY-MM') AS mes,\n" +
            "        COUNT(*) AS cantidad\n" +
            "    FROM notification n\n" +
            "    WHERE EXTRACT(YEAR FROM n.date_time) = :year\n" +
            "    GROUP BY mes\n" +
            "    ORDER BY mes",nativeQuery = true)
    public List<String[]> countNotificationsByMonthInYear(@Param("year") int year);
}
