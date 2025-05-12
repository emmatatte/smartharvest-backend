package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Recomendacion;

public interface IRecomendacionRepository extends JpaRepository<Recomendacion, Integer> {
}
