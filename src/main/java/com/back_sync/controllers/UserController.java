package com.back_sync.controllers;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back_sync.dao.UserRepository;
import com.back_sync.models.User;


@RestController
// Adding /api to every route
@RequestMapping("/api")
// Accept Cross origin calls
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
public class UserController {
	private UserRepository user_repo;
	
	public UserController(UserRepository user_repo) {
		this.user_repo = user_repo;
	}
	// Get a list of all users
	@GetMapping("/users")
    Collection<User> Users() {
        return user_repo.findAll();
    }
	// Get a single user by id
    @GetMapping("/user/{id}")
    ResponseEntity<?> getGroup(@PathVariable String id) {
        Optional<User> user = user_repo.findById(id);
        return user.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    // Update user method
    @PutMapping("/user/{id}")
    ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
        User result = user_repo.save(user);
        return ResponseEntity.ok().body(result);
    }

}
