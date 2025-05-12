package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.smartharvest.entities.ProductoMercado;

public interface IProductoMercadoRepository extends JpaRepository<ProductoMercado, Integer> {
}
