package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Mantenimiento;

import java.util.List;

public interface IMantenimientoService {
    List<Mantenimiento> list();
    void insert(Mantenimiento mantenimiento);
    void update(Mantenimiento mantenimiento);
    void delete(int idMantenimiento);
}
