package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Notificacion;
import pe.edu.upc.smartharvest.repositories.INotificacionRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.INotificacionService;

import java.util.List;

@Service
public class NotificacionServiceImplement implements INotificacionService {
    @Autowired
    private INotificacionRepository nR;

    @Override
    public List<Notificacion> list() {return nR.findAll();}

    @Override
    public void insert(Notificacion n) {nR.save(n);}

    @Override
    public void update(Notificacion n) {nR.save(n);}

    @Override
    public void delete(int idNotificacion) {nR.deleteById(idNotificacion);}
}
