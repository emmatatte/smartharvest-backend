package pe.edu.upc.smartharvest.servicesinterfaces;

import pe.edu.upc.smartharvest.entities.Company;

import java.util.List;

public interface ICompanyService {
    List<Company> list();
    void insert(Company company);
    void update(Company company);
    void delete(int idCompany);
}
