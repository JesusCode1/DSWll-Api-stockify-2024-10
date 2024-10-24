package pe.ciberted.edu.stockify.stockify.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.ciberted.edu.stockify.stockify.entity.Admin;
import pe.ciberted.edu.stockify.stockify.repository.AdminRepository;
import pe.ciberted.edu.stockify.stockify.services.AdminService;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findById(Integer id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin save(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));  // Encriptar contraseña
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> update(Integer id, Admin admin) {
        if (adminRepository.existsById(id)) {
            admin.setAdmin_id(id);
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            return Optional.of(adminRepository.save(admin));
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {
        adminRepository.deleteById(id);
    }

    @PostConstruct
    public void encryptExistingPasswords() {
        List<Admin> admins = adminRepository.findAll();
        for (Admin admin : admins) {
            if (!admin.getPassword().startsWith("$2a$")) {
                String encodedPassword = passwordEncoder.encode(admin.getPassword());
                admin.setPassword(encodedPassword);
                adminRepository.save(admin);
                System.out.println("Contraseña encriptada para: " + admin.getUsername());
            }
        }
    }
}
