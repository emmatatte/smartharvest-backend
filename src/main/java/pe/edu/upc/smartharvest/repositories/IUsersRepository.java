package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Users;

import java.util.List;

@Repository

public interface IUsersRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
    @Query(value = "SELECT COUNT(*) AS users_quantity\n" +
            "FROM users\n" +
            "WHERE enabled is true;",nativeQuery = true)
    public List<String[]> getUsersQuantity();
}
