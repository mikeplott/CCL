package com.CCL.entities.paperwork;

import com.CCL.entities.employees.SalesRep;
import com.CCL.entities.products.Product;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;

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
    private Date orderDate;

    @Column(nullable = false)
    private ArrayList<Product> items;

    @Column(nullable = false)
    private Date deliveryDate;

    @ManyToOne
    SalesRep salesRep;

    public Order() {
    }

    public Order(String accountName, long accountNumber, Date orderDate, ArrayList<Product> items, Date deliveryDate,
                 SalesRep
            salesRep) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.orderDate = orderDate;
        this.items = items;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }
}