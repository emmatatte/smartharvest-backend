package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Notificacion;

public interface INotificacionRepository extends JpaRepository <Notificacion, Integer>{
}
