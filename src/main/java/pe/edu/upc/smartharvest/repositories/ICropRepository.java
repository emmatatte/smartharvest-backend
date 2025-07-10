package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Crop;
import pe.edu.upc.smartharvest.entities.Sensor;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICropRepository extends JpaRepository<Crop, Integer> {
    List<Crop> findByTypeCrop(String typeCrop); // US27
    List<Crop> findByActualState(String actualState); // US27

    List<Crop> findCropsByParcel_Users_Id(Long parcelUsersId);

    // Reporte e - porcentaje de cultivos en peligro
    @Query(value = "SELECT \n" +
            "    p.id_parcel,\n" +
            "    p.name AS parcel_name,\n" +
            "    COUNT(c.id_crop) AS total_crops,\n" +
            "    COUNT(CASE WHEN c.actual_state IN ('Seco', 'Enfermo', 'Plagas') THEN 1 END) AS crops_at_risk,\n" +
            "    ROUND(\n" +
            "        COUNT(CASE WHEN c.actual_state IN ('Seco', 'Enfermo', 'Plagas') THEN 1 END) * 100.0 / \n" +
            "        NULLIF(COUNT(c.id_crop), 0), \n" +
            "    1) AS risk_percentage\n" +
            "FROM public.parcel p\n" +
            "JOIN public.crop c ON p.id_parcel = c.id_parcela\n" +
            "WHERE p.user_id = :idUser\n" +
            "GROUP BY p.id_parcel, p.name\n" +
            "HAVING COUNT(CASE WHEN c.actual_state IN ('Seco', 'Enfermo', 'Plagas') THEN 1 END) > 0\n" +
            "ORDER BY risk_percentage DESC;", nativeQuery = true)
    public List<String[]> findCropRiskPercentageByParcel(@Param("idUser") Long idUser);

    // US31 Identificar cultivos que necesitan atención inmediata
    @Query(value = "SELECT c.id_crop, c.type_crop, p.name, c.actual_state, c.sowing_date\n" +
            "FROM crop c\n" +
            "JOIN parcel p ON c.id_parcela = p.id_parcel\n" +
            "WHERE c.actual_state IN ('Seco', 'Enfermo', 'Plagas')\n" +
            "AND p.user_id = :idUser\n" +
            "ORDER BY c.sowing_date", nativeQuery = true)
    public List<String[]> findCropsNeedingAttention(@Param("idUser") Long idUser);

    // US32 Identificar dias de cultivos proximos
    @Query(value = "SELECT\n" +
            "c.actual_state,\n" +
            "COUNT(*) AS cantidad\n" +
            "FROM crop c\n" +
            "JOIN parcel p ON c.id_parcela = p.id_parcel\n" +
            "WHERE p.user_id = :idUser\n" +
            "GROUP BY c.actual_state\n" +
            "ORDER BY cantidad DESC", nativeQuery = true)
    public List<String[]> CropsByActualState(@Param("idUser") Long idUser);

    //US33 Obtener cultivos activos por parcela
    @Query(value="SELECT c.id_crop, c.actual_state, p.name, c.type_crop, c.sowing_date, p.id_parcel FROM crop c\n" +
            "JOIN parcel p ON c.id_parcela = p.id_parcel\n" +
            "WHERE c.actual_state = 'Listo para cosecha'", nativeQuery = true)
    public List<String[]> findActiveCrops();

    //REPORTE 4
    @Query(value = "SELECT c.type_crop,\n" +
            "COUNT(*) AS cantidad\n" +
            "FROM crop c\n" +
            "JOIN parcel p ON c.id_parcela = p.id_parcel\n" +
            "WHERE p.user_id = :idUser\n" +
            "AND c.estimated_harvest_date BETWEEN :startDate AND :endDate\n" +
            "AND c.actual_state NOT IN ('Plagas', 'Enfermo', 'Seco')\n" +
            "GROUP BY c.type_crop\n" +
            "ORDER BY cantidad DESC", nativeQuery = true)
    List<String[]> countHarvestByCropTypeInRange(@Param("startDate") LocalDate startDate,
                                                 @Param("endDate") LocalDate endDate,
                                                 @Param("idUser") Long idUser);
}
