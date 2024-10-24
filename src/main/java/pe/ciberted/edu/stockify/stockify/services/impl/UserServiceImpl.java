package pe.ciberted.edu.stockify.stockify.services.impl;

import org.springframework.stereotype.Service;
import pe.ciberted.edu.stockify.stockify.dto.UserDTO;
import pe.ciberted.edu.stockify.stockify.entity.Location;
import pe.ciberted.edu.stockify.stockify.entity.User;
import pe.ciberted.edu.stockify.stockify.repository.LocationRepository;
import pe.ciberted.edu.stockify.stockify.repository.UserRepository;
import pe.ciberted.edu.stockify.stockify.services.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LocationRepository locationRepository;

    public UserServiceImpl(UserRepository userRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(this::convertToDTO);
    }

    @Override
    public UserDTO save(User user) {
        // Asignar la ubicación si existe
        if (user.getLocation() != null && user.getLocation().getLocation_id() > 0) {
            Location location = locationRepository.findById(user.getLocation().getLocation_id())
                    .orElseThrow(() -> new RuntimeException("Location not found"));
            user.setLocation(location);
        }
        User savedUser = userRepository.save(user);
        return convertToDTO(savedUser);
    }

    @Override
    public Optional<UserDTO> update(int id, User user) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhone_number(user.getPhone_number());
            existingUser.setStatus(user.getStatus());

            // Actualizar la ubicación si corresponde
            if (user.getLocation() != null && user.getLocation().getLocation_id() > 0) {
                Location location = locationRepository.findById(user.getLocation().getLocation_id())
                        .orElseThrow(() -> new RuntimeException("Location not found"));
                existingUser.setLocation(location);
            }

            User updatedUser = userRepository.save(existingUser);
            return convertToDTO(updatedUser);
        });
    }

    @Override
    public void deleteById(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getUser_id(),
                user.getName(),
                user.getEmail(),
                user.getPhone_number(),
                user.getStatus(),
                user.getLocation() != null ? user.getLocation().getLocation_name() : null,
                user.getLocation() != null ? user.getLocation().getLocation_id() : 0
        );
    }
}
