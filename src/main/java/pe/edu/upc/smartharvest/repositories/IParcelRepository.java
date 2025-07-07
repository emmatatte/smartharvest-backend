package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Parcel;

import java.util.List;

@Repository
public interface IParcelRepository extends JpaRepository<Parcel, Integer> {
    List<Parcel> findParcelByUsers_Id(Long usersId);

    //US35
    @Query(value = "SELECT p.id_parcel, p.name\n" +
            "FROM parcel p\n" +
            "WHERE p.registration_date >= CURRENT_DATE - INTERVAL '30 days'",nativeQuery = true)
    public List<String[]> findActiveParcels();

    @Query(value = "SELECT \n" +
            "    TO_CHAR(p.registration_date, 'YYYY-MM') AS mes,\n" +
            "    COUNT(*) AS cantidad\n" +
            "FROM parcel p\n" +
            "WHERE EXTRACT(YEAR FROM p.registration_date) = :year\n" +
            "GROUP BY mes\n" +
            "ORDER BY mes\n",nativeQuery = true)
    public List<String[]> countParcelsByMonthInYear(@Param("year") int year);
}
