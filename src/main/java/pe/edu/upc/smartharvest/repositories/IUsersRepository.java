package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Users;

public interface IUsersRepository extends JpaRepository<Users, Integer> {
    public Users findOneByUsername(String username);
}
