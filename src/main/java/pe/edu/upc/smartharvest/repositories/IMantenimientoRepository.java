package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Mantenimiento;

public interface IMantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {

}
