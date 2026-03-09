package com.vishnu.auth_service.config;


import com.vishnu.auth_service.entity.Role;
import com.vishnu.auth_service.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName("ADMIN").isEmpty()) roleRepository.save(new Role("ADMIN"));
            if (roleRepository.findByName("TRADER").isEmpty()) roleRepository.save(new Role("TRADER"));
            if (roleRepository.findByName("VIEWER").isEmpty()) roleRepository.save(new Role("VIEWER"));
        };
    }
}

