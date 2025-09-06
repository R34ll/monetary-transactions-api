package finance.api.adapters.inbound.controllers.web.springboot;

import org.springframework.web.bind.annotation.RestController;

import finance.api.application.usecases.CreateAccountUseCase;
import finance.api.application.usecases.DeleteAccountByIdUseCase;
import finance.api.application.usecases.FindAccountByIdUseCase;
import finance.api.application.usecases.UpdateAccountByIdUseCase;
import finance.api.domain.entities.Account;
import finance.api.domain.valueobjects.Money;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import finance.api.domain.valueobjects.EntityId;
import org.springframework.http.HttpStatus;
import finance.api.adapters.dtos.CreateAccountResponseDto;
import finance.api.adapters.dtos.AccountResponseDto;
import finance.api.adapters.dtos.CreateAccountRequestDto;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    // 1. Create a new account
    // 2. Get account by ID
    // 3. Update Account Details
    // 4. Delete account
    // 5. List all acconts
    // 6. List all transactions of account
    // 7. Return balance
    // 8. Get user's account
    // 9. Switch Account status

    private final CreateAccountUseCase createAccountUseCase;
    private final FindAccountByIdUseCase findAccountByIdUseCase;
    private final DeleteAccountByIdUseCase deleteAccountByIdUseCase;
    private final UpdateAccountByIdUseCase updateAccountByIdUseCase;

@Autowired
    public AccountController(
            CreateAccountUseCase createAccountUseCase,
            FindAccountByIdUseCase findAccountByIdUseCase,
            DeleteAccountByIdUseCase deleteAccountByIdUseCase,
            UpdateAccountByIdUseCase updateAccountByIdUseCase) 
        {

        this.createAccountUseCase = createAccountUseCase;
        this.findAccountByIdUseCase = findAccountByIdUseCase;
        this.deleteAccountByIdUseCase = deleteAccountByIdUseCase;
        this.updateAccountByIdUseCase = updateAccountByIdUseCase;
    }

    @PostMapping
    public ResponseEntity<CreateAccountResponseDto> createAccount(@RequestBody CreateAccountRequestDto request) {
        System.out.println("Account create new for user: " + request.userId());
        Account account = createAccountUseCase.execute(new EntityId(request.userId()));
        System.out.println("Account ID: " + account.getId().getValue());
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateAccountResponseDto.from(account));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> getAccountById(@PathVariable("id") String id) {
        Account account = findAccountByIdUseCase.execute(new EntityId(id));
        if (account == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(AccountResponseDto.from(account));
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Account> updateAccount(@RequestBody UpdateAccountDto requzzzest) {
    //     Account account = updateAccountByIdUseCase.execute(new EntityId(request.id()), request);
    //     if (account == null)
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //     return ResponseEntity.ok(AccountResponseDto.from(account));
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteAccount(@PathVariable("id") String id) {
    //     deleteAccountByIdUseCase.exeute(new EntityId(id));
    //     return ResponseEntity.noContent().build();
    // }

}
