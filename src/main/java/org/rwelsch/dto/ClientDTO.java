package org.rwelsch.dto;

import java.math.BigDecimal;
import java.util.List;

public class ClientDTO {

    private int id;

    private BigDecimal savings;

    private List<OperationDTO> operations;

    public ClientDTO() {
    }

    public ClientDTO(int id, BigDecimal savings, List<OperationDTO> operations) {
        this.id = id;
        this.savings = savings;
        this.operations = operations;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getSavings() {
        return savings;
    }

    public void setSavings(BigDecimal savings) {
        this.savings = savings;
    }

    public List<OperationDTO> getOperations() {
        return operations;
    }
}
