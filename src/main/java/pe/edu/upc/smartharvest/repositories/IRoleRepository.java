package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
