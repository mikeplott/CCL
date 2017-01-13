package com.CCL.entities.employees;

import com.CCL.entities.paperwork.Report;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Mike on 1/12/2017.
 */
@Entity
@Table(name = "employees")
public class EmpMetaData {

    @Id
    @GeneratedValue
    private String id;

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

    @Column
    @ElementCollection(targetClass = Report.class)
    private List<Report> reports;

    public EmpMetaData() {
    }

    public EmpMetaData(String firstName, String middleName, String lastName, String address, Date DOB, Date hireDate,
                       boolean currentEmployee, long salary, long ssn, List<Report> reports) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.DOB = DOB;
        this.hireDate = hireDate;
        this.currentEmployee = currentEmployee;
        this.salary = salary;
        this.ssn = ssn;
        this.reports = reports;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
