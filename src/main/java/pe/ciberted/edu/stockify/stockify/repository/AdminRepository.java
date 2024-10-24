package pe.ciberted.edu.stockify.stockify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.ciberted.edu.stockify.stockify.entity.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUsername(String username);
}
