package com.CCL.entities.employees;

import javax.persistence.Column;
import java.sql.Timestamp;

/**
 * Created by michaelplott on 1/3/17.
 */
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
    private String employeeReviews;

    @Column(nullable = false)
    private Timestamp DOB;

    @Column(nullable = false)
    private Timestamp hireDate;

    @Column()
    private Timestamp severanceDate;

    @Column(nullable = false)
    private boolean currentEmployee;

    @Column(nullable = false)
    private long salary;

    @Column(nullable = false)
    private long ssn;
}
