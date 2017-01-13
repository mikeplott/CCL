package com.CCL.entities.employees;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by michaelplott on 1/3/17.
 */
@MappedSuperclass
public abstract class Employee {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Date DOB;

    @Column(nullable = false)
    private Date hireDate;

    @Column(nullable = false)
    private boolean currentEmployee;

    @Column(nullable = false)
    private long salary;

    @Column(nullable = false)
    private long ssn;

    public Employee() {
    }

    public Employee(String firstName, String middleName, String lastName, String address, Date DOB, Date hireDate,
                    boolean currentEmployee, long salary, long ssn) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.DOB = DOB;
        this.hireDate = hireDate;
        this.currentEmployee = currentEmployee;
        this.salary = salary;
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isCurrentEmployee() {
        return currentEmployee;
    }

    public void setCurrentEmployee(boolean currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }
}
