package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.SensorIot;
import pe.edu.upc.smartharvest.repositories.ISensorIotRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.ISensorIotService;

import java.util.List;

@Service
public class SensorIotServiceImplement implements ISensorIotService {
    @Autowired
    private ISensorIotRepository sR;

    @Override
    public List<SensorIot> list() {return sR.findAll();}

    @Override
    public void insert(SensorIot s) {
        sR.save(s);
    }

    @Override
    public void update(SensorIot s) {
        sR.save(s);
    }

    @Override
    public void delete(int idSensor) {
        sR.deleteById(idSensor);
    }


}
