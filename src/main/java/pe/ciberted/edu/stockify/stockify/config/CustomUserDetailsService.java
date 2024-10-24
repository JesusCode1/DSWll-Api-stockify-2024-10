package pe.ciberted.edu.stockify.stockify.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.ciberted.edu.stockify.stockify.entity.Admin;
import pe.ciberted.edu.stockify.stockify.repository.AdminRepository;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> user = adminRepository.findByUsername(username);
        if (user.isPresent()) {
            String storedPassword = user.get().getPassword();
            return new User(username, storedPassword, new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User Does Not Exist");
        }
    }
}
