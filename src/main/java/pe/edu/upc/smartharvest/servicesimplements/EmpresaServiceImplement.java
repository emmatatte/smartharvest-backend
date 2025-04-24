package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Empresa;
import pe.edu.upc.smartharvest.repositories.IEmpresaRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.IEmpresaService;

import java.util.List;

@Service
public class EmpresaServiceImplement implements IEmpresaService {
    @Autowired
    private IEmpresaRepository eR;

    @Override
    public List<Empresa> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Empresa empresa) {
        eR.save(empresa);
    }

    @Override
    public void update(Empresa empresa) {
        eR.save(empresa);
    }

    @Override
    public void delete(int idEmpresa) {
        eR.deleteById(idEmpresa);
    }
}
