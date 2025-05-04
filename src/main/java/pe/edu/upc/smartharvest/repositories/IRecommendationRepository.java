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
}
