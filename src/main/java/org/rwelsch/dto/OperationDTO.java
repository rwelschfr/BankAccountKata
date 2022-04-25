package org.rwelsch.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class OperationDTO {

    private Instant date;

    private BigDecimal amount;

    public OperationDTO() {
    }

    public OperationDTO(Instant date, BigDecimal amount) {
        this.date = date;
        this.amount = amount;
    }

    public Instant getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
