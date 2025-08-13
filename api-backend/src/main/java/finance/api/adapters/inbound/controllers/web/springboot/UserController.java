package finance.api.adapters.inbound.controllers.web.springboot;
import finance.api.adapters.dtos.CreateUserRequestDto;
import finance.api.domain.entities.User;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/user")
public class UserController{
    // 1. Create new User
    // 2. Get user by ID
    // 3. Update user details
    // 4. Delete user
    // 5. List all users

    @PostMapping(consumes = "application/json")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequestDto createUserRequestDto){}

    @GetMapping()
    public void getUserById(Long id){}
    
    @PostMapping()
    public void updateUser(){}
    
    @DeleteMapping()
    public void deleteUser(){}
    
    @GetMapping
    public void listAllUsers(){}

}   
