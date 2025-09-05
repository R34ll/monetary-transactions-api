package finance.api.adapters.dtos;

import finance.api.domain.entities.Transaction;

public record TransactionResponseDto(String fromAccount, String toAccount, String amount){
    public static TransactionResponseDto from(Transaction transaction){
        return new TransactionResponseDto(
            transaction.getFromAccountId() != null ? transaction.getFromAccountId().getValue() : null,
            transaction.getToAccountId() != null ? transaction.getToAccountId().getValue() : null,
            transaction.getAmount() != null ? transaction.getAmount().getValue().toString() : null
        );
    }
}