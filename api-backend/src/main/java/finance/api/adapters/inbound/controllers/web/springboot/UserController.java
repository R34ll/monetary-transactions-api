package finance.api.adapters.inbound.controllers.web.springboot;
import finance.api.adapters.dtos.CreateUserRequestDto;
import finance.api.adapters.dtos.UpdateUserRequestDto;
import finance.api.adapters.dtos.UserResponseDto;



import finance.api.application.usecases.CreateUserUseCase;
import finance.api.application.usecases.FindUserByIdUseCase;
import finance.api.application.usecases.UpdateUserByIdUseCase;
import finance.api.application.usecases.DeleteUserByIdUseCase;
import finance.api.application.usecases.FindAllUsersUseCase;



import finance.api.domain.entities.User;
import finance.api.domain.entities.User.UserType;

import finance.api.domain.valueobjects.EntityId;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

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
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final UpdateUserByIdUseCase UpdateUserByIdUseCase;
    private final DeleteUserByIdUseCase deleteUserByIdUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;

    @Autowired
    public UserController(
        CreateUserUseCase createUserUseCase,
        FindUserByIdUseCase findUserByIdUseCase,
        UpdateUserByIdUseCase updateUserByIdUseCase,
        DeleteUserByIdUseCase deleteUserByIdUseCase,
        FindAllUsersUseCase findAllUsersUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.findUserByIdUseCase = findUserByIdUseCase;
        this.UpdateUserByIdUseCase = updateUserByIdUseCase;
        this.deleteUserByIdUseCase = deleteUserByIdUseCase;
        this.findAllUsersUseCase = findAllUsersUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto request) {
        User user = createUserUseCase.execute(
            request.name(),
            request.email(),
            request.password(),
            request.document(),
            UserType.CUSTOMER
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(UserResponseDto.from(user));
    }



    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") String id) {
        User user = findUserByIdUseCase.execute(new EntityId(id));
        if (user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(UserResponseDto.from(user));
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("id") String id, @RequestBody CreateUserRequestDto request) {
        User user = UpdateUserByIdUseCase.execute(new EntityId(id), request);
        if (user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(UserResponseDto.from(user));
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        deleteUserByIdUseCase.execute(new EntityId(id));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> listAllUsers() {
        List<User> users = findAllUsersUseCase.execute();
        List<UserResponseDto> response = users.stream()
            .map(UserResponseDto::from)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}   



