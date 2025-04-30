package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Sensor;

public interface ISensorRepository extends JpaRepository<Sensor, Integer> {
  @Query("SELECT s FROM Sensor s WHERE s.parcel.id = :idParcela AND s.fecha BETWEEN :inicio AND :fin")
    List<Sensor> obtenerDatosSatelitalesPorParcela(
      @Param("idParcela") Long idParcela,
      @Param("inicio") LocalDate inicio,
      @Param("fin") LocalDate fin
      );
}
