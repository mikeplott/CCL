package com.CCL.entities.accounts;

import com.CCL.entities.employees.SalesRep;
import javax.persistence.*;
import java.sql.Date;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;

    @Column()
    private String owner;

    @Column()
    private String receiver;

    @Column()
    private String buyer;

    @Column()
    private String abcLicense;

    @Column()
    private String businessLicense;

    @Column()
    private boolean isOnPremise;

    @Column()
    private boolean isClassBWholeSaler;

    @Column()
    private boolean isSupplier;

    @Column()
    private boolean isPastDue;

    @Column()
    private boolean isSpecialEvent;

    @Column()
    private Date abcIssueDate;

    @Column()
    private Date abcExpiration;

    @Column()
    private String zipCode;

    @Column()
    private String phoneNumber;

    @Column()
    private String accountNumber;

    @Column()
    private double balance;

    @ManyToOne
    SalesRep salesRep;

    public Account() {
    }

    public Account(String name, String address, String city, String state, String owner, String receiver, String buyer,
                   String abcLicense, String businessLicense, boolean isOnPremise, boolean isClassBWholeSaler,
                   boolean isSupplier, boolean isPastDue, boolean isSpecialEvent, Date abcIssueDate, Date abcExpiration,
                   String zipCode, String phoneNumber, String accountNumber, double balance, SalesRep salesRep) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.owner = owner;
        this.receiver = receiver;
        this.buyer = buyer;
        this.abcLicense = abcLicense;
        this.businessLicense = businessLicense;
        this.isOnPremise = isOnPremise;
        this.isClassBWholeSaler = isClassBWholeSaler;
        this.isSupplier = isSupplier;
        this.isPastDue = isPastDue;
        this.isSpecialEvent = isSpecialEvent;
        this.abcIssueDate = abcIssueDate;
        this.abcExpiration = abcExpiration;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.salesRep = salesRep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAbcLicense() {
        return abcLicense;
    }

    public void setAbcLicense(String abcLicense) {
        this.abcLicense = abcLicense;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public boolean isOnPremise() {
        return isOnPremise;
    }

    public void setOnPremise(boolean onPremise) {
        isOnPremise = onPremise;
    }

    public boolean isClassBWholeSaler() {
        return isClassBWholeSaler;
    }

    public void setClassBWholeSaler(boolean classBWholeSaler) {
        isClassBWholeSaler = classBWholeSaler;
    }

    public boolean isSupplier() {
        return isSupplier;
    }

    public void setSupplier(boolean supplier) {
        isSupplier = supplier;
    }

    public boolean isPastDue() {
        return isPastDue;
    }

    public void setPastDue(boolean pastDue) {
        isPastDue = pastDue;
    }

    public boolean isSpecialEvent() {
        return isSpecialEvent;
    }

    public void setSpecialEvent(boolean specialEvent) {
        isSpecialEvent = specialEvent;
    }

    public Date getAbcIssueDate() {
        return abcIssueDate;
    }

    public void setAbcIssueDate(Date abcIssueDate) {
        this.abcIssueDate = abcIssueDate;
    }

    public Date getAbcExpiration() {
        return abcExpiration;
    }

    public void setAbcExpiration(Date abcExpiration) {
        this.abcExpiration = abcExpiration;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }
}