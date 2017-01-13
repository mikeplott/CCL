package com.CCL.entities.employees;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "warehouse")
public class WarehouseRep extends Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private boolean isForkLiftCertified;

    @Column(nullable = false)
    private boolean isBackUpDriver;

    @Column(nullable = false)
    private boolean isDayShift;

    @Column(nullable = false)
    private String productArea;

    @Column()
    private String forkLiftLicenseNumber;

    public WarehouseRep() {
    }

    public WarehouseRep(String firstName, String middleName, String lastName, String address, Date DOB, Date hireDate,
                        boolean currentEmployee, long salary, long ssn, boolean isForkLiftCertified, boolean isBackUpDriver, boolean isDayShift,
                        String productArea, String forkLiftLicenseNumber) {
        super(firstName, middleName, lastName, address, DOB, hireDate, currentEmployee, salary, ssn);
        this.isForkLiftCertified = isForkLiftCertified;
        this.isBackUpDriver = isBackUpDriver;
        this.isDayShift = isDayShift;
        this.productArea = productArea;
        this.forkLiftLicenseNumber = forkLiftLicenseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isForkLiftCertified() {
        return isForkLiftCertified;
    }

    public void setForkLiftCertified(boolean forkLiftCertified) {
        isForkLiftCertified = forkLiftCertified;
    }

    public boolean isBackUpDriver() {
        return isBackUpDriver;
    }

    public void setBackUpDriver(boolean backUpDriver) {
        isBackUpDriver = backUpDriver;
    }

    public boolean isDayShift() {
        return isDayShift;
    }

    public void setDayShift(boolean dayShift) {
        isDayShift = dayShift;
    }

    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public String getForkLiftLicenseNumber() {
        return forkLiftLicenseNumber;
    }

    public void setForkLiftLicenseNumber(String forkLiftLicenseNumber) {
        this.forkLiftLicenseNumber = forkLiftLicenseNumber;
    }
}
