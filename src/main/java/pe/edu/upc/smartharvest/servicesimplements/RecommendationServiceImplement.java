package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Maintenance;
import pe.edu.upc.smartharvest.entities.Recommendation;
import pe.edu.upc.smartharvest.repositories.IRecommendationRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IRecommendationService;

import java.util.List;

@Service
public class RecommendationServiceImplement implements IRecommendationService {
    @Autowired
    private IRecommendationRepository rR;

    @Override
    public List<Recommendation> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Recommendation recommendation) {
        rR.save(recommendation);
    }

    @Override
    public void update(Recommendation recommendation) {
        rR.save(recommendation);
    }

    @Override
    public void delete(int idRecommendation) {
        rR.deleteById(idRecommendation);
    }

    @Override
    public Recommendation listId(int idRecommendation) {
        return rR.findById(idRecommendation).orElse(new Recommendation());
    }

    @Override
    public List<Recommendation> findByCropId(Integer cropId) {
        return rR.findByCropId(cropId);
    }

    @Override
    public List<Recommendation> findByUserId(Integer userId) {
        return rR.findByUserId(userId);
    }

    @Override
    public List<Recommendation> findByLowHumiditySensors(Double threshold) {
        return rR.findByLowHumiditySensors(threshold);
    }

    @Override
    public List<String[]> findRecommendationCountByParcel() {
        return rR.findRecommendationCountByParcel();
    }

    @Override
    public List<String[]> recommendationsByMonth(int year) {
        return rR.recommendationsByMonth(year);
    }

    @Override
    public List<String[]> findRecommendations(){
        return rR.findRecommendations();
    }
}
