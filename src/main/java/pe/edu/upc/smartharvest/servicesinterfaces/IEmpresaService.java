package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Empresa;

import java.util.List;

public interface IEmpresaService {
    List<Empresa> list();
    void insert(Empresa empresa);
    void update(Empresa empresa);
    void delete(int idEmpresa);
}
