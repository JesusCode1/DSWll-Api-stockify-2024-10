package pe.ciberted.edu.stockify.stockify.services.impl;

import org.springframework.stereotype.Service;
import pe.ciberted.edu.stockify.stockify.dto.AssetDTO;
import pe.ciberted.edu.stockify.stockify.entity.Asset;
import pe.ciberted.edu.stockify.stockify.entity.Category;
import pe.ciberted.edu.stockify.stockify.entity.Location;
import pe.ciberted.edu.stockify.stockify.entity.User;
import pe.ciberted.edu.stockify.stockify.repository.AssetRepository;
import pe.ciberted.edu.stockify.stockify.repository.CategoryRepository;
import pe.ciberted.edu.stockify.stockify.repository.LocationRepository;
import pe.ciberted.edu.stockify.stockify.repository.UserRepository;
import pe.ciberted.edu.stockify.stockify.services.AssetService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final CategoryRepository categoryRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public AssetServiceImpl(AssetRepository assetRepository, CategoryRepository categoryRepository, LocationRepository locationRepository, UserRepository userRepository) {
        this.assetRepository = assetRepository;
        this.categoryRepository = categoryRepository;
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AssetDTO> findAll() {
        List<Asset> assets = assetRepository.findAll();
        return assets.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<AssetDTO> findById(int id) {
        Optional<Asset> asset = assetRepository.findById(id);
        return asset.map(this::convertToDTO);
    }

    @Override
    public AssetDTO save(AssetDTO assetDTO) {
        Asset asset = new Asset();
        asset.setAsset_name(assetDTO.getAssetName());
        asset.setAsset_description(assetDTO.getAssetDescription());
        asset.setModel(assetDTO.getModel());
        asset.setManufacturer(assetDTO.getManufacturer());
        asset.setSerial_number(assetDTO.getSerialNumber());

        Category category = categoryRepository.findById(assetDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        asset.setCategory(category);

        Location location = locationRepository.findById(assetDTO.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));
        asset.setLocation(location);

        asset.setPurchase_date(assetDTO.getPurchaseDate());
        asset.setPurchase_price(assetDTO.getPurchasePrice());
        asset.setWarranty(assetDTO.getWarranty());
        asset.setAsset_status(Asset.AssetStatus.valueOf(assetDTO.getAssetStatus().toLowerCase()));

        return convertToDTO(assetRepository.save(asset));
    }

    @Override
    public AssetDTO update(int id, AssetDTO assetDTO) {
        Asset asset = assetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        asset.setAsset_name(assetDTO.getAssetName());
        asset.setAsset_description(assetDTO.getAssetDescription());
        asset.setModel(assetDTO.getModel());
        asset.setManufacturer(assetDTO.getManufacturer());
        asset.setSerial_number(assetDTO.getSerialNumber());

        Category category = categoryRepository.findById(assetDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        asset.setCategory(category);

        Location location = locationRepository.findById(assetDTO.getLocationId())
                .orElseThrow(() -> new RuntimeException("Location not found"));
        asset.setLocation(location);

        asset.setPurchase_date(assetDTO.getPurchaseDate());
        asset.setPurchase_price(assetDTO.getPurchasePrice());
        asset.setWarranty(assetDTO.getWarranty());
        asset.setAsset_status(Asset.AssetStatus.valueOf(assetDTO.getAssetStatus().toLowerCase()));

        return convertToDTO(assetRepository.save(asset));
    }

    @Override
    public void delete(int id) {
        assetRepository.deleteById(id);
    }

    public AssetDTO convertToDTO(Asset asset) {
        return new AssetDTO(
                asset.getAsset_id(),
                asset.getAsset_name(),
                asset.getAsset_description(),
                asset.getModel(),
                asset.getManufacturer(),
                asset.getSerial_number(),
                asset.getCategory() != null ? asset.getCategory().getCategory_id() : 0,
                asset.getLocation() != null ? asset.getLocation().getLocation_id() : 0,
                asset.getPurchase_date(),
                asset.getPurchase_price(),
                asset.getWarranty(),
                asset.getAsset_status() != null ? asset.getAsset_status().name() : null,
                asset.getAssigned_to() != null ? asset.getAssigned_to().getName() : null,
                asset.getAdmin() != null ? asset.getAdmin().getUsername() : null
        );
    }
    public AssetDTO assignAssetToUser(int assetId, int userId) {
        Asset asset = assetRepository.findById(assetId)
                .orElseThrow(() -> new RuntimeException("Asset not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        asset.setAssigned_to(user);
        asset.setAsset_status(Asset.AssetStatus.assigned);

        assetRepository.save(asset);
        return convertToDTO(asset);
    }


}
