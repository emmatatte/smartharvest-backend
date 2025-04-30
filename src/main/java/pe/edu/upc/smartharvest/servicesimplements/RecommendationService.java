package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Recommendation;
import pe.edu.upc.smartharvest.repositories.IRecommendationRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IRecommendationService;

import java.util.List;

@Service
public class RecommendationService implements IRecommendationService {
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
}
