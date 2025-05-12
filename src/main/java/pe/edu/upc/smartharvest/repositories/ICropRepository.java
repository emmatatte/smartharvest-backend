package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Crop;

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
    @Query(value = "SELECT c.id_crop, c.type_crop, p.name , c.sowing_date,\n" +
            "c.estimated_harvest_date, (c.estimated_harvest_date::date - CURRENT_DATE),\n" +
            "CASE \n" +
            "        WHEN (c.estimated_harvest_date::date - CURRENT_DATE) <= 0 THEN 'Cosecha Atrasada'\n" +
            "        WHEN (c.estimated_harvest_date::date - CURRENT_DATE) <= 7 THEN 'Cosecha Urgente (≤7 días)'\n" +
            "        WHEN (c.estimated_harvest_date::date - CURRENT_DATE) <= 30 THEN 'Cosecha Próxima (8-30 días)'\n" +
            "        WHEN (c.estimated_harvest_date::date - CURRENT_DATE) <= 90 THEN 'Cosecha Programada (1-3 meses)'\n" +
            "        WHEN (c.estimated_harvest_date::date - CURRENT_DATE) <= 180 THEN 'Cosecha a Mediano Plazo (3-6 meses)'\n" +
            "        WHEN (c.estimated_harvest_date::date - CURRENT_DATE) <= 300 THEN 'Cosecha a Largo Plazo (6-10 meses)'\n" +
            "        ELSE 'Cosecha Futura (>10 meses)'\n" +
            "END AS \"Estado Cosecha\"\n" +
            "FROM public.crop c\n" +
            "JOIN public.parcel p ON c.id_parcela = p.id_parcel\n" +
            "WHERE c.actual_state = 'Activo' AND c.estimated_harvest_date IS NOT NULL", nativeQuery = true)
    public List<String[]> identifyUpcomingCropDays();
    
}
