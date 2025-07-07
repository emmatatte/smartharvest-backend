package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Crop;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICropRepository extends JpaRepository<Crop, Integer> {
    List<Crop> findByTypeCrop(String typeCrop); // US27
    List<Crop> findByActualState(String actualState); // US27

    // US31 Identificar cultivos que necesitan atención inmediata
    @Query(value = "SELECT c.id_crop, c.type_crop, p.name,\n" +
            "c.actual_state, c.sowing_date \n" +
            "FROM public.crop c\n" +
            "JOIN public.parcel p ON c.id_parcela = p.id_parcel\n" +
            "WHERE c.actual_state IN ('Seco', 'Enfermo', 'Plagas')\n" +
            "ORDER BY c.sowing_date;", nativeQuery = true)
    public List<String[]> findCropsNeedingAttention();

    // US32 Identificar dias de cultivos proximos
    @Query(value = "SELECT \n" +
            "        c.actual_state,\n" +
            "        COUNT(*) AS cantidad\n" +
            "    FROM crop c\n" +
            "    GROUP BY c.actual_state\n" +
            "    ORDER BY cantidad DESC", nativeQuery = true)
    public List<String[]> CropsByActualState();

    //US33 Obtener cultivos activos por parcela
    @Query(value="SELECT c.id_crop, c.actual_state, p.name, c.type_crop, c.sowing_date, p.id_parcel FROM crop c\n" +
            "JOIN parcel p ON c.id_parcela = p.id_parcel\n" +
            "WHERE c.actual_state = 'Listo para cosecha'", nativeQuery = true)
    public List<String[]> findActiveCrops();

    //REPORTE 4
    @Query(value = "SELECT c.type_crop,\n" +
            "        COUNT(*) AS cantidad\n" +
            "    FROM crop c\n" +
            "    WHERE c.estimated_harvest_date BETWEEN :startDate AND :endDate\n" +
            "      AND c.actual_state NOT IN ('Plagas', 'Enfermo', 'Seco')\n" +
            "    GROUP BY c.type_crop\n" +
            "    ORDER BY cantidad DESC", nativeQuery = true)
    List<String[]> countHarvestByCropTypeInRange(@Param("startDate") LocalDate startDate,
                                                 @Param("endDate") LocalDate endDate);
}
