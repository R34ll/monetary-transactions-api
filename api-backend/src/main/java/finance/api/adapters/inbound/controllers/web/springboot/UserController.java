package finance.api.adapters.inbound.controllers.web.springboot;
import finance.api.adapters.dtos.CreateUserRequestDto;
import finance.api.application.usecases.CreateUserUseCase;
import finance.api.domain.entities.User;
import finance.api.domain.entities.User.UserType;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/users")
public class UserController{
    // 1. Create new User
    // 2. Get user by ID
    // 3. Update user details
    // 4. Delete user
    // 5. List all users

    private final CreateUserUseCase createUserUseCase;


    @Autowired
    public UserController(CreateUserUseCase createUserUseCase){
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestDto request){
        
        try{
            User user = createUserUseCase.execute(
                request.name(), 
                request.email(), 
                request.password(), 
                request.document(), 
                UserType.CUSTOMER
            );
            return ResponseEntity.ok(user); // TODO: Map to response DTO
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(Long id){return null;}
    
    @PostMapping("/{id}")
    public ResponseEntity<?> updateUser(){return null;}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(){return null;}
    
    @GetMapping
    public ResponseEntity<?> listAllUsers(){return null;}

}   
