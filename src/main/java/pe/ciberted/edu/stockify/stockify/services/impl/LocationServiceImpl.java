package pe.ciberted.edu.stockify.stockify.services.impl;

import org.springframework.stereotype.Service;
import pe.ciberted.edu.stockify.stockify.dto.LocationDTO;
import pe.ciberted.edu.stockify.stockify.entity.Location;
import pe.ciberted.edu.stockify.stockify.repository.LocationRepository;
import pe.ciberted.edu.stockify.stockify.services.LocationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<LocationDTO> findAll() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<LocationDTO> findById(int id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.map(this::convertToDTO);
    }

    @Override
    public Location saveLocation(LocationDTO locationDTO) {
        Location location = new Location();
        location.setLocation_name(locationDTO.getLocationName());
        location.setLocation_description(locationDTO.getLocationDescription());
        return locationRepository.save(location);
    }

    @Override
    public LocationDTO updateLocation(int id, LocationDTO locationDTO) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));

        location.setLocation_name(locationDTO.getLocationName());
        location.setLocation_description(locationDTO.getLocationDescription());

        locationRepository.save(location);
        return convertToDTO(location);
    }

    @Override
    public void deleteLocation(int id) {
        locationRepository.deleteById(id);
    }

    private LocationDTO convertToDTO(Location location) {
        return new LocationDTO(
                location.getLocation_id(),
                location.getLocation_name(),
                location.getLocation_description()
        );
    }
}
