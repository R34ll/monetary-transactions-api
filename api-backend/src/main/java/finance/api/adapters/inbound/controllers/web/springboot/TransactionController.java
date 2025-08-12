package finance.api.adapters.inbound.controllers.web.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class TransactionController {

    @GetMapping
    public String ping() {
        return "ok";
    }

}