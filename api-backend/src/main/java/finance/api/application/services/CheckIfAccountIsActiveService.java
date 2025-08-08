package finance.api.application.services;

import finance.api.domain.entities.Account;
import finance.api.domain.entities.Account.Status;
import finance.api.application.exceptions.AccountNullException;
import finance.api.application.exceptions.AccountWithNoActiveStatusException;


public class CheckIfAccountIsActiveService{

    public void check(Account account){
        if(account == null){
            throw new AccountNullException();

        }

        if(account.getStatus() != Status.ACTIVE){
            throw new AccountWithNoActiveStatusException();
        }
    }

}
