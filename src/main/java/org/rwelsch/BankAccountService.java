package org.rwelsch;

import org.rwelsch.dto.ClientDTO;
import org.rwelsch.dto.OperationDTO;
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
        return clients.stream().filter(c -> c.getId() == id).findFirst().get();
    }

    public ClientDTO deposit(int id, BigDecimal amount) {
        return addOperation(id, amount);
    }

    public ClientDTO withdraw(int id, BigDecimal amount) {
        return addOperation(id, amount.negate());
    }

    public List<OperationDTO> getHistory(int id) {
        return getClient(id).getOperations();
    }

    private ClientDTO addOperation(int id, BigDecimal amount) {
        ClientDTO client = getClient(id);
        OperationDTO operation = new OperationDTO(Instant.now(), amount);
        client.getOperations().add(operation);
        client.setSavings(client.getSavings().add(amount));
        return client;
    }

}
