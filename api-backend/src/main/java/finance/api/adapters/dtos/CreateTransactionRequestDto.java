package finance.api.adapters.dtos;


public record CreateTransactionRequestDto(String fromAccount, String toAccount, String balance){}

