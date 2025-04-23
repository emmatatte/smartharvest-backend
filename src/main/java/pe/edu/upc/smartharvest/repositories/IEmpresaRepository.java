package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Empresa;

public interface IEmpresaRepository extends JpaRepository<Empresa, Integer> {
}
