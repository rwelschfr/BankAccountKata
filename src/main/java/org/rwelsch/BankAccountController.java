package org.rwelsch;

import org.rwelsch.dto.OperationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class BankAccountController {

    private final BankAccountService bankAccountService = new BankAccountService();

    @PutMapping("/{id}/deposit")
    public ResponseEntity deposit(@PathVariable int id, @RequestBody double amount) {
        return ResponseEntity.ok(bankAccountService.deposit(id, new BigDecimal(amount)));
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity withdraw(@PathVariable int id, @RequestBody double amount) {
        return ResponseEntity.ok(bankAccountService.withdraw(id, new BigDecimal(amount)));
    }

    @GetMapping("/{id}/history")
    public List<OperationDTO> getHistory(@PathVariable int id) {
        return bankAccountService.getHistory(id);
    }
}
