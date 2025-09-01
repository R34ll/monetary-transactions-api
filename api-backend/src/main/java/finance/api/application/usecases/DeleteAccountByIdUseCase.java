package finance.api.application.usecases;

import finance.api.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DeleteAccountByIdUseCase{

    private final AccountRepository accountRepository;

    @Autowired
    public DeleteAccountByIdUseCase(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

}