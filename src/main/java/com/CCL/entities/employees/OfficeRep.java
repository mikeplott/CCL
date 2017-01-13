package com.CCL.entities.employees;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "officestaff")
public class OfficeRep extends Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String jobTitle;

    public OfficeRep() {
    }

    public OfficeRep(String firstName, String middleName, String lastName, String address, Date DOB, Date hireDate,
                     boolean currentEmployee, long salary, long ssn, String department, String jobTitle) {
        super(firstName, middleName, lastName, address, DOB, hireDate, currentEmployee, salary, ssn);
        this.department = department;
        this.jobTitle = jobTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
