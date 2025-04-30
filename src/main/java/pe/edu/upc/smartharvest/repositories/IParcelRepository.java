package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Parcel;

public interface IParcelRepository extends JpaRepository<Parcel, Integer> {
}
