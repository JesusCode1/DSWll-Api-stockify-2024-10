package pe.ciberted.edu.stockify.stockify.services;

import pe.ciberted.edu.stockify.stockify.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> findAll();
    Optional<Admin> findById(Integer id);
    Admin save(Admin admin);
    Optional<Admin> update(Integer id, Admin admin);
    void deleteById(Integer id);
}
