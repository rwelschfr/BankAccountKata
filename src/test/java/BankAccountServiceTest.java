import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.rwelsch.BankAccountService;
import org.rwelsch.dto.ClientDTO;
import org.rwelsch.dto.OperationDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BankAccountServiceTest {

    @InjectMocks
    private BankAccountService bankAccountService;

    @Test
    public void testGetClient() {
        assertNotNull(bankAccountService.getClient(1));
        assertEquals(1, bankAccountService.getClient(1).getId());
        assertThrows(NoSuchElementException.class, () -> bankAccountService.getClient(3));
    }

    @Test
    public void testDeposit() {
        ClientDTO client = bankAccountService.deposit(1, new BigDecimal(100));
        assertEquals(new BigDecimal(100), client.getSavings());
    }

    @Test
    public void testWithdraw() {
        ClientDTO client = bankAccountService.withdraw(2, new BigDecimal(100));
        assertEquals(BigDecimal.ZERO, client.getSavings());
    }

    @Test
    public void testGetHistory() {
        List<OperationDTO> operations = bankAccountService.getHistory(2);
        assertNotNull(operations);
        assertEquals(2, operations.size());
        assertEquals(new BigDecimal(20), operations.get(0).getAmount());
    }

}
