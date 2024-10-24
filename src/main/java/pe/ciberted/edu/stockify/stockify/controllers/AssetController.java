package pe.ciberted.edu.stockify.stockify.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.ciberted.edu.stockify.stockify.dto.AssetDTO;
import pe.ciberted.edu.stockify.stockify.services.AssetService;

import java.util.List;

@RestController
@RequestMapping("/api/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public ResponseEntity<List<AssetDTO>> findAll() {
        List<AssetDTO> assets = assetService.findAll();
        return ResponseEntity.ok(assets);
    }

    @PostMapping
    public ResponseEntity<AssetDTO> create(@RequestBody AssetDTO assetDTO) {
        AssetDTO createdAsset = assetService.save(assetDTO);
        return ResponseEntity.ok(createdAsset);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetDTO> update(@PathVariable int id, @RequestBody AssetDTO assetDTO) {
        AssetDTO updatedAsset = assetService.update(id, assetDTO);
        return ResponseEntity.ok(updatedAsset);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        assetService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{assetId}/assign/{userId}")
    public ResponseEntity<AssetDTO> assignAssetToUser(@PathVariable int assetId, @PathVariable int userId) {
        AssetDTO updatedAsset = assetService.assignAssetToUser(assetId, userId);
        return ResponseEntity.ok(updatedAsset);
    }

}
