package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Maintenance;
import pe.edu.upc.smartharvest.entities.Recommendation;


import java.util.List;

public interface IRecommendationService {
    List<Recommendation> list();
    void insert(Recommendation recommendation);
    void update(Recommendation recommendation);
    void delete(int idRecommendation);
    List<Recommendation> findByCropId(Integer cropId);
    List<Recommendation> findByUserId(Integer userId);
    List<String[]> findRecommendationCountByParcel();
    List<String[]> recommendationsByMonth(int year);
    public List<String[]> findRecommendations();
    Recommendation listId(int idRecommendation);
    List<Recommendation> findRecommendationsByCrop_Parcel_Users_Id(Long cropParcelUsersId);
}
