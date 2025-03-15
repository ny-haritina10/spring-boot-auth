package mg.itu.admin.service;

import mg.itu.admin.model.Admin;
import mg.itu.admin.repository.AdminRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Admin findByEmail(String email) {
        logger.debug("Finding admin by email: {}", email);
        Admin admin = adminRepository.findByEmail(email);
        if (admin != null) {
            logger.debug("Admin found: {}", admin.getEmail());
        } else {
            logger.debug("No admin found for email: {}", email);
        }
        return admin;
    }

    public boolean authenticate(String email, String password) {
        logger.debug("Authenticating email: {}", email);
        logger.debug("Provided password: {}", password);

        Admin admin = findByEmail(email);
        if (admin != null) {
            logger.debug("Stored password hash: {}", admin.getPasswordHash());
            boolean matches = passwordEncoder.matches(password, admin.getPasswordHash());
            logger.debug("Password match result: {}", matches);
            return matches;
        }
        logger.debug("Authentication failed: Admin not found");
        return false;
    }
}