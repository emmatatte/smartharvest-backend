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
}
