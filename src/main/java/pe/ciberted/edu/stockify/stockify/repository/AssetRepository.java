package pe.ciberted.edu.stockify.stockify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.ciberted.edu.stockify.stockify.entity.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {
}
