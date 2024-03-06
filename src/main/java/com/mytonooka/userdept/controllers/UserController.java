package com.mytonooka.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mytonooka.userdept.entities.User;
import com.mytonooka.userdept.exceptions.ResourceNotFoundException;
import com.mytonooka.userdept.repositories.UserRepository;

@RestController
@RequestMapping (value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> findAlls(){
		List<User> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id){
		
		User result = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));
		
		return result;
		
	}
	
	@PostMapping
	public User insert(@RequestBody User user){
		User result = repository.save(user);
		return result;
	}
	
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        repository.deleteById(id);
        return ResponseEntity.ok("User deleted successfully!.");
    }      

}
