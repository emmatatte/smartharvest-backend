package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Maintenance;
import pe.edu.upc.smartharvest.entities.Recommendation;


import java.util.List;

public interface IRecommendationService {
    List<Recommendation> list();
    void insert(Recommendation recommendation);
    void update(Recommendation recommendation);
    void delete(int idRecommendation);
    public Recommendation listId(int idRecommendation);
    List<Recommendation> findByCropId(Integer cropId);
    List<Recommendation> findByUserId(Integer userId);
    List<Recommendation> findByLowHumiditySensors(Double threshold);
    List<String[]> findRecommendationCountByParcel();

    public List<String[]> findRecommendations();
}
