package finance.api.application.services;

import finance.api.domain.entities.Account;
import finance.api.domain.entities.Account.Status;;

public class CheckIfAccountIsActiveService{

    public void check(Account account){
        if(account == null){
            throw new IllegalArgumentException("Account cannot be null");
        }

        if(account.getStatus() != Status.ACTIVE){
            throw new IllegalArgumentException("Account not active");
        }
    }

}
