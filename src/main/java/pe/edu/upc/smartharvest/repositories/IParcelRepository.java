package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Parcel;

import java.util.List;

@Repository
public interface IParcelRepository extends JpaRepository<Parcel, Integer> {
    List<Parcel> findByUsers_IdUser(Integer userId);

    //US35
    @Query(value = "SELECT p.id, p.nombre\n" +
            "FROM parcel p\n" +
            "WHERE p.registrationDate >= CURRENT_DATE - INTERVAL '30 days'",nativeQuery = true)
    public List<String[]> findActiveParcels();
}
