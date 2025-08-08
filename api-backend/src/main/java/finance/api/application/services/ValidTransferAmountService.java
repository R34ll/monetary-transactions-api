package finance.api.application.services;
import java.math.BigDecimal;

import finance.api.domain.entities.Account;
import finance.api.domain.valueobjects.Money;


public class ValidTransferAmountService{
    private final Money ZERO = new Money(BigDecimal.valueOf(0));


    public void valid(Money transferAmount){
        if(transferAmount == null ){
            throw new IllegalArgumentException("Transfer amount cannot be null");
        }

        if(transferAmount.compareTo(ZERO) < 1){
            throw new IllegalArgumentException("Invalid amount.");
        }


    }


}



