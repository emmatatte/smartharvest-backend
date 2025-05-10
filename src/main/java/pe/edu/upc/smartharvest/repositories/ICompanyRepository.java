package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Company;
@Repository
public interface ICompanyRepository extends JpaRepository<Company, Integer> {
  //US17
  @Query(value = "SELECT id_company, name, description, mission, vision\n" +
           "FROM public.company\n" +
           "ORDER BY id_company ASC;", nativeQuery = true)
  public List<String[]> viewCompanyInformation();
  
}
