package pe.edu.upc.smartharvest.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.smartharvest.entities.Company;
import pe.edu.upc.smartharvest.repositories.ICompanyRepository;
import pe.edu.upc.smartharvest.servicesinterfaces.ICompanyService;

import java.util.List;

@Service
public class CompanyServiceImplement implements ICompanyService {
    @Autowired
    private ICompanyRepository eR;

    @Override
    public List<Company> list() {
        return eR.findAll();
    }

    @Override
    public void insert(Company company) {
        eR.save(company);
    }

    @Override
    public void update(Company company) {
        eR.save(company);
    }

    @Override
    public void delete(int idEmpresa) {
        eR.deleteById(idEmpresa);
    }

    @Override
    public Company listId(int idCompany) {
        return eR.findById(idCompany).orElse(new Company());
    }
}
