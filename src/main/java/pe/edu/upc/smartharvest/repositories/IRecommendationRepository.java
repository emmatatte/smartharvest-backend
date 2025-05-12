package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Recommendation;

import java.util.List;

@Repository
public interface IRecommendationRepository extends JpaRepository<Recommendation, Integer> {
    @Query("SELECT r FROM Recommendation r WHERE r.crop.idCrop = :cropId")
    List<Recommendation> findByCropId(@Param("cropId") Integer cropId);
    @Query("SELECT r FROM Recommendation r WHERE r.users.idUser = :userId")
    List<Recommendation> findByUserId(@Param("userId") Integer userId);
    @Query("SELECT r FROM Recommendation r WHERE r.crop.idCrop IN (SELECT s.crop.idCrop FROM Sensor s WHERE s.humidity < :threshold)")
    List<Recommendation> findByLowHumiditySensors(@Param("threshold") Double threshold);
    @Query(value = "SELECT p.name AS parcela, COUNT(r.id_recommendation) AS total_recomendaciones " +
            "FROM recommendation r " +
            "JOIN crop c ON r.id_crop = c.id_crop " +
            "JOIN parcel p ON c.id_parcela = p.id_parcel " +
            "GROUP BY p.name " +
            "ORDER BY total_recomendaciones DESC", nativeQuery = true)
    List<String[]> findRecommendationCountByParcel();
}
