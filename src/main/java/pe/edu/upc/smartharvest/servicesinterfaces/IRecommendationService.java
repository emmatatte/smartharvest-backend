package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.ProductMarket;
import pe.edu.upc.smartharvest.entities.Recommendation;

import java.util.List;

public interface IRecommendationService {
    List<Recommendation> list();
    void insert(Recommendation recommendation);
    void update(Recommendation recommendation);
    void delete(int idRecommendation);
}
