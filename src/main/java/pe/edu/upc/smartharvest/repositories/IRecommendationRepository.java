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
    @Query(value = "SELECT r FROM Recommendation r WHERE r.users.id_user = :userId", nativeQuery = true)
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
    //US36
    @Query(value = "SELECT r.id_recommendation, r.description, c.id_crop AS crop, c.type_crop, c.actual_state\n" +
            "FROM recommendation r\n" +
            "JOIN crop c ON r.id_crop = c.id_crop\n" +
            "ORDER BY r.id_recommendation;", nativeQuery = true)
    public List<String[]> findRecommendations();
}
