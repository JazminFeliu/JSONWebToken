package com.example.jsonwebtoken;

import com.example.jsonwebtoken.domain.Role;
import com.example.jsonwebtoken.domain.User;
import com.example.jsonwebtoken.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JsonWebTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonWebTokenApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Jazmin Feliu", "jaz", "jaz", new ArrayList<>()));
            userService.saveUser(new User(null, "Santiago Feliu", "san", "san", new ArrayList<>()));
            userService.saveUser(new User(null, "Sebastian Gauna", "seba", "seba", new ArrayList<>()));
            userService.saveUser(new User(null, "Juan Farinatti", "juan", "juan", new ArrayList<>()));
            userService.saveUser(new User(null, "Rocio Rolando", "ro", "ro", new ArrayList<>()));
            userService.saveUser(new User(null, "Diego Crededdio", "diego", "diego", new ArrayList<>()));

            userService.addRoleToUser("jaz", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("jaz", "ROLE_ADMIN");
            userService.addRoleToUser("jaz", "ROLE_USER");
            userService.addRoleToUser("san", "ROLE_ADMIN");
            userService.addRoleToUser("seba","ROLE_MANAGER");
            userService.addRoleToUser("seba","ROLE_ADMIN");
            userService.addRoleToUser("juan","ROLE_ADMIN");
            userService.addRoleToUser("ro","ROLE_MANAGER");
            userService.addRoleToUser("diego", "ROLE_USER");
        };
    }

}
