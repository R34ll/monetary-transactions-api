package finance.api.adapters.inbound.controllers.web.springboot;

import org.springframework.web.bind.annotation.RestController;

import finance.api.application.usecases.CreateAccountUseCase;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/accounts")
public class AccountController{
    // 1. Create a new account
    // 2. Get account by ID
    // 3. Update Account Details
    // 4. Delete account
    // 5. List all acconts
    // 6. List all transactions of account
    // 7. Return balance
    // 8. Get user's account


    private final CreateAccountUseCase createAccountUseCase;
    private final FindAccountByIdUseCase findAccountByIdUseCase;
    private final DeleteAccountByIdUseCase deleteAccountByIdUseCase;
    private final UpdateAccountByIdUseCase updateAccountByIdUseCase;


    @Autowired
    public AccountController(
        CreateAccountUseCase createAccountUseCase, 
        FindAccountByIdUseCase findAccountByIdUseCase,
        DeleteAccountByIdUseCase deleteAccountByIdUseCase,
        UpdateAccountByIdUseCase updateAccountByIdUseCase
    ){
        this.createAccountUseCase = createAccountUseCase;
        this.findAccountByIdUseCase = findAccountByIdUseCase;
        this.deleteAccountByIdUseCase = deleteAccountByIdUseCase;
        this.updateAccountByIdUseCase = updateAccountByIdUseCase;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") String id){
        return null;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody CreateAccountUseCase request){
        return null;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@RequestBody UpdateAccountUseCase request){
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") String id){
        return null;
    }



    



}
