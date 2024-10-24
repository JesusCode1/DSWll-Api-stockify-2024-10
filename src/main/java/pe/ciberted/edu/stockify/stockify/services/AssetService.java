package pe.ciberted.edu.stockify.stockify.services;

import pe.ciberted.edu.stockify.stockify.dto.AssetDTO;
import java.util.List;
import java.util.Optional;

public interface AssetService {
    List<AssetDTO> findAll();
    Optional<AssetDTO> findById(int id);
    AssetDTO save(AssetDTO assetDTO);
    AssetDTO update(int id, AssetDTO assetDTO);
    AssetDTO assignAssetToUser(int assetId, int userId);
    void delete(int id);
}
