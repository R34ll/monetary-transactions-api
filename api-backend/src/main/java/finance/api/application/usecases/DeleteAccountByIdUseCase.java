package finance.api.application.usecases;

import finance.api.application.exceptions.AccountNotFoundException;
import finance.api.domain.entities.Account;
import finance.api.domain.repository.AccountRepository;
import finance.api.domain.valueobjects.EntityId;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DeleteAccountByIdUseCase{

    private final AccountRepository accountRepository;

    @Autowired
    public DeleteAccountByIdUseCase(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public void execute(EntityId accountId){
        if(!accountRepository.findById(accountId).isPresent()) throw new AccountNotFoundException();

        accountRepository.deleteById(accountId);
    }

}
