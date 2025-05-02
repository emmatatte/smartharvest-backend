package pe.edu.upc.smartharvest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.smartharvest.entities.ShareAction;

import java.util.List;

@Repository
public interface IShareActionRepository extends JpaRepository<ShareAction, Long> {
    List<ShareAction> findBySharedContent(String sharedContent); // US06
}