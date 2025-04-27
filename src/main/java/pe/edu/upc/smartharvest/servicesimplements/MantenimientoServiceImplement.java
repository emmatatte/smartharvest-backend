package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Mantenimiento;
import pe.edu.upc.smartharvest.repositories.IMantenimientoRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IMantenimientoService;

import java.util.List;

@Service
public class MantenimientoServiceImplement implements IMantenimientoService {
    @Autowired
    private IMantenimientoRepository mR;

    @Override
    public List<Mantenimiento> list(){
        return mR.findAll();
    }

    @Override
    public void insert(Mantenimiento m) {
        mR.save(m);
    }

    @Override
    public void update(Mantenimiento m) {
        mR.save(m);
    }

    @Override
    public void delete(int idMantenimiento) {
        mR.deleteById(idMantenimiento);
    }
}
