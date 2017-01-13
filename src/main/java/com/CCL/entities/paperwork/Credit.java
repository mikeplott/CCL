package com.CCL.entities.paperwork;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "credits")
public class Credit {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private long creditNumber;

    @Column(nullable = false)
    private BigDecimal creditAmount;

    @Column(nullable = false)
    private Timestamp creditDate;

    @Column(nullable = false)
    private boolean isActive;

    public Credit() {
    }

    public Credit(long creditNumber, BigDecimal creditAmount, Timestamp creditDate, boolean isActive) {
        this.creditNumber = creditNumber;
        this.creditAmount = creditAmount;
        this.creditDate = creditDate;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(long creditNumber) {
        this.creditNumber = creditNumber;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Timestamp getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(Timestamp creditDate) {
        this.creditDate = creditDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
