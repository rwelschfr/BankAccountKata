import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/clients")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity deposit(@PathVariable Long id, @RequestBody BigDecimal amount) {
        return null;
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity withdraw(@PathVariable Long id, @RequestBody BigDecimal amount) {
        return null;
    }

    @GetMapping("/{id}/history")
    public ResponseEntity getHistory(@PathVariable Long id) {
        return null;
    }
}
