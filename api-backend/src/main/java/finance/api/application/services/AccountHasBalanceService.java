package finance.api.application.services;
import java.math.BigDecimal;

import finance.api.domain.entities.Account;
import finance.api.domain.valueobjects.Money;
import finance.api.application.exceptions.AccountWithInsufficientBalanceException;
import finance.api.application.exceptions.TransferAmountNullException;

public class AccountHasBalanceService {
    private final Money ZERO = new Money(BigDecimal.valueOf(0));

    public void check(Account account, Money amount) {
        if (amount == null) {
            throw new TransferAmountNullException();
        }

        Money result = account.getBalance().subtract(amount);

        if (result.compareTo(ZERO) < 1) {
            throw new AccountWithInsufficientBalanceException();
        }
    }
}

