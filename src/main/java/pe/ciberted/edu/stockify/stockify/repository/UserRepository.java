package pe.ciberted.edu.stockify.stockify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.ciberted.edu.stockify.stockify.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
