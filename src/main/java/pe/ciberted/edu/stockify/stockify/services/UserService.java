package pe.ciberted.edu.stockify.stockify.services;

import pe.ciberted.edu.stockify.stockify.dto.UserDTO;
import pe.ciberted.edu.stockify.stockify.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAll();
    Optional<UserDTO> findById(int id);
    UserDTO save(User user);
    Optional<UserDTO> update(int id, User user);
    void deleteById(int id);
}
