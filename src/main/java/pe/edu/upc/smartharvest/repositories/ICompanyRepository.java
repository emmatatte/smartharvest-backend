package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Company;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {
}
