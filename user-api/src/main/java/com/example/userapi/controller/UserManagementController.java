package com.example.userapi.controller;

import com.example.userapi.entity.UserEntity;
import com.example.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "")

// Update with your frontend URL
public class UserManagementController {

    @Autowired
    private UserRepository userRepository;

    // Endpoint to get all users
    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // Endpoint to get a user by ID
    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping("/new_users")
//    public ResponseEntity<?> createUser(@RequestBody UserEntity user) {
//        try {
//            UserEntity createdUser = userRepository.save(user);
//            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//        } catch (Exception e) {
//            e.printStackTrace(); // Log error details
//            return new ResponseEntity<>("Error creating user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    // Endpoint to create a new user
    @PostMapping("/new_users")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    // Endpoint to update an existing user
    @PutMapping("/complete_update_users/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody UserEntity userDetails) {
        Optional<UserEntity> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            UserEntity updatedUser = existingUser.get();
            updatedUser.setFname(userDetails.getFname());
            updatedUser.setLname(userDetails.getLname());
            updatedUser.setEmail(userDetails.getEmail());
            userRepository.save(updatedUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete a user
    @DeleteMapping("/delete_users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
