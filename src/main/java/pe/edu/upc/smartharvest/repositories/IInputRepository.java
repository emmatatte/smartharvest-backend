package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.Input;

import java.util.List;

@Repository
public interface IInputRepository extends JpaRepository<Input,Integer> {
    List<Input> findByUsers_Id(Long usersId);
}
