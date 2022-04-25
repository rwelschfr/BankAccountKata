import dto.ClientDTO;
import dto.OperationDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.*;

@Service
public class BankAccountService {

    // Persistence stub
    private Set<ClientDTO> clients = new HashSet<>();

    public BankAccountService() {
        // Sample data
        clients.add(new ClientDTO(1, new BigDecimal(0), new ArrayList<>()));

        List<OperationDTO> operations = new ArrayList<>();
        operations.add(new OperationDTO(Instant.now(), new BigDecimal(20)));
        operations.add(new OperationDTO(Instant.now(), new BigDecimal(80)));
        clients.add(new ClientDTO(2, new BigDecimal(100), operations));
    }

    public ClientDTO getClient(int id) throws NoSuchElementException {
        return null;
    }

    public ClientDTO deposit(int id, BigDecimal amount) {
        return null;
    }

    public ClientDTO withdraw(int id, BigDecimal amount) throws IllegalStateException {
        return null;
    }

    public List<OperationDTO> getHistory(int id) {
        return null;
    }

}
