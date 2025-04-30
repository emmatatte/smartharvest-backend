package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
