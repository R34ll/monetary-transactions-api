package finance.api.application.services;

import finance.api.domain.entities.Account;

public class CheckIfSameAccountService{
    public void check(Account oneAccount, Account twoAccount){
        if(oneAccount == null || twoAccount == null){
            throw new IllegalArgumentException("Account cannot be null");
        }

        if(oneAccount.getId().equals(twoAccount.getId())){
            throw new IllegalArgumentException("Both accounts are the same");

        }
    }
}


