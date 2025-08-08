package finance.api.application.services;

import finance.api.application.exceptions.AccountNullException;
import finance.api.application.exceptions.SameAccountTransferException;
import finance.api.domain.entities.Account;


public class CheckIfSameAccountService{
    public void check(Account oneAccount, Account twoAccount){
        if(oneAccount == null || twoAccount == null){
            throw new AccountNullException();
        }

        if(oneAccount.getId().equals(twoAccount.getId())){
            throw new SameAccountTransferException();

        }
    }
}


