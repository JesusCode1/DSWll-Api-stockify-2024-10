package pe.ciberted.edu.stockify.stockify.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.ciberted.edu.stockify.stockify.dto.LocationDTO;
import pe.ciberted.edu.stockify.stockify.entity.Location;
import pe.ciberted.edu.stockify.stockify.services.LocationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<LocationDTO>> findAll() {
        List<LocationDTO> locations = locationService.findAll();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> findById(@PathVariable int id) {
        Optional<LocationDTO> location = locationService.findById(id);
        return location.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LocationDTO> createLocation(@RequestBody LocationDTO locationDTO) {
        Location savedLocation = locationService.saveLocation(locationDTO);
        LocationDTO savedLocationDTO = new LocationDTO(
                savedLocation.getLocation_id(),
                savedLocation.getLocation_name(),
                savedLocation.getLocation_description()
        );
        return ResponseEntity.ok(savedLocationDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationDTO> updateLocation(
            @PathVariable int id, @RequestBody LocationDTO locationDTO) {
        LocationDTO updatedLocation = locationService.updateLocation(id, locationDTO);
        return ResponseEntity.ok(updatedLocation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable int id) {
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }
}
