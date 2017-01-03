package com.CCL.entities.accounts;

import com.CCL.entities.employees.SalesRep;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String accountName;

    @Column(nullable = false)
    private long accountNumber;

    @Column(nullable = false)
    private Timestamp orderDate;

    @Column(nullable = false)
    private Timestamp deliveryDate;

    @ManyToOne
    SalesRep salesRep;

    public Order() {
    }

    public Order(String accountName, long accountNumber, Timestamp orderDate, Timestamp deliveryDate, SalesRep salesRep) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.salesRep = salesRep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Timestamp deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }
}
