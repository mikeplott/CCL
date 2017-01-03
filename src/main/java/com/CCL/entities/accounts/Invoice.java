package com.CCL.entities.accounts;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private long invoiceNumber;

    @Column()
    private long checkNumber;

    @Column(nullable = false)
    private BigDecimal invoiceTotal;

    @Column()
    private BigDecimal checkAmount;

    @Column(nullable = false)
    private Timestamp orderDate;

    @Column(nullable = false)
    private boolean isPaid;

    @ManyToOne
    Account account;

    public Invoice() {
    }

    public Invoice(long invoiceNumber, long checkNumber, BigDecimal invoiceTotal, BigDecimal checkAmount, Timestamp orderDate, boolean isPaid, Account account) {
        this.invoiceNumber = invoiceNumber;
        this.checkNumber = checkNumber;
        this.invoiceTotal = invoiceTotal;
        this.checkAmount = checkAmount;
        this.orderDate = orderDate;
        this.isPaid = isPaid;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(long invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public long getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(long checkNumber) {
        this.checkNumber = checkNumber;
    }

    public BigDecimal getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(BigDecimal invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    public BigDecimal getCheckAmount() {
        return checkAmount;
    }

    public void setCheckAmount(BigDecimal checkAmount) {
        this.checkAmount = checkAmount;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
