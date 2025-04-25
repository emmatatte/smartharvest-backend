package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Parcela;

public interface IParcelaRepository extends JpaRepository<Parcela, Integer> {
}
