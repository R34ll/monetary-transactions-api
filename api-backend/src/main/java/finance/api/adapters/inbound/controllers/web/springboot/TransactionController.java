package finance.api.adapters.inbound.controllers.web.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    // 1. Create new Transaction
    // 2. List all Transactions
    // 3. Return a transaction by transaction id
    
    @GetMapping
    public String ping() {
        return "ok";
    }



    public void newTransaction(){}
    public void getTransaction(){}
    public void getAllTransactions(){}



}



/*
    api/transaction
    - Post: Create new transaction


*/