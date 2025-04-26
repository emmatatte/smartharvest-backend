package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Insumo;

public interface IInsumoRepository extends JpaRepository<Insumo,Integer> {
}
