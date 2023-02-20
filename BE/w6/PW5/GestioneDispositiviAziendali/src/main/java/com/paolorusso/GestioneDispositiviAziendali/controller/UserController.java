package com.paolorusso.GestioneDispositiviAziendali.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paolorusso.GestioneDispositiviAziendali.entities.User;
import com.paolorusso.GestioneDispositiviAziendali.service.UserService;




@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
    private UserService usServ;
	
	@GetMapping
	public ResponseEntity<List<User>> getUser() {
        List<User> users = usServ.getAll();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
	
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("id") int id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        Optional<User> user = usServ.getById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id) {
        Optional<User> userOptional = usServ.getById(id);
        if (userOptional.isPresent()) {
        	User userToUpdate = userOptional.get();
            userToUpdate.setUsername(userToUpdate.getUsername());
            userToUpdate.setFullname(userToUpdate.getFullname());
            userToUpdate.setEmail(userToUpdate.getEmail());
            userToUpdate.setPassword(userToUpdate.getPassword());
            usServ.insert(userToUpdate);
            return ResponseEntity.ok("User aggiornato con successo");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L' user con ID " + id + " non è stato trovato");
        }
    }
	@PostMapping("/update")
    public ResponseEntity<String> addUser(@RequestBody User user) {
    	usServ.insert(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("user inserito con successo");
    }
	
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        try {
        	usServ.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("user eliminato con successo");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@PostMapping("/login_success")
	public String login_success() {
		return "login success";
	}
	
	@GetMapping("/page3")
	@PreAuthorize("hasRole('ADMIN')")
	public String page3() {
		return "page 3";
	}
	
}
