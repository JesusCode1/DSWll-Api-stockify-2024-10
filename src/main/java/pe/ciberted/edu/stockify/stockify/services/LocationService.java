package pe.ciberted.edu.stockify.stockify.services;

import pe.ciberted.edu.stockify.stockify.dto.LocationDTO;
import pe.ciberted.edu.stockify.stockify.entity.Location;

import java.util.List;
import java.util.Optional;

public interface LocationService {
    List<LocationDTO> findAll();
    Optional<LocationDTO> findById(int id);
    Location saveLocation(LocationDTO locationDTO);
    LocationDTO updateLocation(int id, LocationDTO locationDTO);
    void deleteLocation(int id);
}
