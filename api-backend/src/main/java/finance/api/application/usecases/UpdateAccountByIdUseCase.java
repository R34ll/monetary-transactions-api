package finance.api.application.usecases;

import finance.api.domain.repository.AccountRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UpdateAccountByIdUseCase{
    private final AccountRepository accountRepository;

    @Autowired
    public UpdateAccountByIdUseCase(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

}


