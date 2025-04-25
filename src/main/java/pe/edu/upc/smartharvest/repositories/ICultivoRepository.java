package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Cultivo;

public interface ICultivoRepository extends JpaRepository<Cultivo, Integer> {
}
