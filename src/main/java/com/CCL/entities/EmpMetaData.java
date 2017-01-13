package com.CCL.entities;

import com.CCL.entities.employees.Employee;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;

/**
 * Created by Mike on 1/12/2017.
 */
@Entity
@Table(name = "employees")
public class EmpMetaData extends Employee {

    private String id;

    private List<Report> reports;

    public EmpMetaData() {
    }

    public EmpMetaData(String firstName, String middleName, String lastName, String address, Date DOB, Date hireDate, boolean currentEmployee, long salary, long ssn, String id, List<Report> reports) {
        super(firstName, middleName, lastName, address, DOB, hireDate, currentEmployee, salary, ssn);
        this.id = id;
        this.reports = reports;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
