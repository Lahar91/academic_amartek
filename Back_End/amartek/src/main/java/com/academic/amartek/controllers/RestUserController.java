package com.academic.amartek.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academic.amartek.models.Role;
import com.academic.amartek.models.User;
import com.academic.amartek.repositories.IRoleRepository;
import com.academic.amartek.repositories.IUserRepository;

@RestController
@RequestMapping("api")
public class RestUserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("roles")
    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        try {
            if(userRepository.existsByEmail(user.getEmail())){
                return ResponseEntity.badRequest().body("Email Already Exists!");
            }
    
            user.setPassword(passwordEncoder.encode(user.getPassword()));
    
            Role role = roleRepository.findByName("Admin");
            user.setRole(role);
    
            userRepository.save(user);
    
            return ResponseEntity.ok("User Successfully Registered");
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        

    }

    @PostMapping("login")
    public  ResponseEntity<String> loginUser(@RequestBody User user){
        if(!userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body("User Not Found");
        }

        User dbUser = userRepository.findByEmail(user.getEmail());

        if(!passwordEncoder.matches(user.getPassword(), dbUser.getPassword())){
            return ResponseEntity.badRequest().body("Incorrect Password");
        }

        return ResponseEntity.ok("Berhasil Login");
    }
}

