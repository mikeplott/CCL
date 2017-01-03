package com.CCL.entities.accounts;

import com.CCL.entities.employees.SalesRep;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

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

    @Column(nullable = false)
    private String abcLicense;

    @Column(nullable = false)
    private String businessLicense;

    @Column(nullable = false)
    private boolean isOnPremise;

    @Column(nullable = false)
    private boolean isClassBWholeSaler;

    @Column(nullable = false)
    private boolean isPastDue;

    @Column(nullable = false)
    private boolean isSpecialEvent;

    @Column(nullable = false)
    private Timestamp abcIssueDate;

    @Column(nullable = false)
    private Timestamp abcExpiration;

    @Column(nullable = false)
    private long zipCode;

    @Column(nullable = false)
    private long phoneNumber;

    @Column(nullable = false)
    private long accountNumber;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne
    SalesRep salesRep;

    public Account() {
    }

    public Account(String name, String address, String city, String state, String owner, String receiver, String buyer,
                   String abcLicense, String businessLicense, boolean isOnPremise, boolean isClassBWholeSaler, boolean isPastDue,
                   boolean isSpecialEvent, Timestamp abcIssueDate, Timestamp abcExpiration, long zipCode, long phoneNumber,
                   long accountNumber, BigDecimal balance, SalesRep salesRep) {
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

    public Account(String name, String address, String city, String state, String abcLicense, String businessLicense,
                   boolean isOnPremise, boolean isClassBWholeSaler, boolean isPastDue, boolean isSpecialEvent, Timestamp abcIssueDate,
                   Timestamp abcExpiration, long zipCode, long phoneNumber, long accountNumber, BigDecimal balance, SalesRep salesRep) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.abcLicense = abcLicense;
        this.businessLicense = businessLicense;
        this.isOnPremise = isOnPremise;
        this.isClassBWholeSaler = isClassBWholeSaler;
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

    public Timestamp getAbcIssueDate() {
        return abcIssueDate;
    }

    public void setAbcIssueDate(Timestamp abcIssueDate) {
        this.abcIssueDate = abcIssueDate;
    }

    public Timestamp getAbcExpiration() {
        return abcExpiration;
    }

    public void setAbcExpiration(Timestamp abcExpiration) {
        this.abcExpiration = abcExpiration;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public SalesRep getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(SalesRep salesRep) {
        this.salesRep = salesRep;
    }
}