package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.AgriculturalProduct;

import java.util.List;

@Repository
public interface IAgriculturalProductRepository extends JpaRepository<AgriculturalProduct, Integer> {
    List<AgriculturalProduct> findAgriculturalProductsByCrop_Parcel_Users_Id(Long cropParcelUsersId);
}
