package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Users;
@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
    public Users findOneByUsername(String username);
}
