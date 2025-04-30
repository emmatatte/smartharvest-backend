package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Rol;

public interface IRolRepository extends JpaRepository<Rol, Integer> {
}
