package com.CCL.entities.employees;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "drivers")
public class Driver extends Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private double breakageCost;

    @Column(nullable = false)
    private double deliveryDollarTotal;

    @Column(nullable = false)
    private int productBreakage;

    @Column(nullable = false)
    private int hoursDriven;

    @Column(nullable = false)
    private long driversLicenseNumber;

    @Column(nullable = false)
    private String motorVehicleRecord;

    @Column(nullable = false)
    private String insurancePolicyNumber;

    @Column()
    private String tuesdayRoute;

    @Column()
    private String wednesdayRoute;

    @Column()
    private String thursdayRoute;

    @Column()
    private String fridayRoute;

    @Column(nullable = false)
    private Date licenseExpirationDate;

    @Column(nullable = false)
    private boolean isCdlCertified;

    @Column(nullable = false)
    private  boolean isBackUpDriver;

    public Driver() {
    }

    public Driver(String firstName, String middleName, String lastName, String address, Date DOB, Date hireDate,
                  boolean currentEmployee, long salary, long ssn, double breakageCost, double deliveryDollarTotal, int productBreakage,
                  int hoursDriven, long driversLicenseNumber, String motorVehicleRecord, String insurancePolicyNumber, String tuesdayRoute,
                  String wednesdayRoute, String thursdayRoute, String fridayRoute, Date licenseExpirationDate, boolean isCdlCertified, boolean isBackUpDriver ) {
        super(firstName, middleName, lastName, address, DOB, hireDate, currentEmployee, salary, ssn);
        this.breakageCost = breakageCost;
        this.deliveryDollarTotal = deliveryDollarTotal;
        this.productBreakage = productBreakage;
        this.hoursDriven = hoursDriven;
        this.driversLicenseNumber = driversLicenseNumber;
        this.motorVehicleRecord = motorVehicleRecord;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.tuesdayRoute = tuesdayRoute;
        this.wednesdayRoute = wednesdayRoute;
        this.thursdayRoute = thursdayRoute;
        this.fridayRoute = fridayRoute;
        this.licenseExpirationDate = licenseExpirationDate;
        this.isCdlCertified = isCdlCertified;
        this.isBackUpDriver = isBackUpDriver;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBreakageCost() {
        return breakageCost;
    }

    public void setBreakageCost(double breakageCost) {
        this.breakageCost = breakageCost;
    }

    public double getDeliveryDollarTotal() {
        return deliveryDollarTotal;
    }

    public void setDeliveryDollarTotal(double deliveryDollarTotal) {
        this.deliveryDollarTotal = deliveryDollarTotal;
    }

    public int getProductBreakage() {
        return productBreakage;
    }

    public void setProductBreakage(int productBreakage) {
        this.productBreakage = productBreakage;
    }

    public int getHoursDriven() {
        return hoursDriven;
    }

    public void setHoursDriven(int hoursDriven) {
        this.hoursDriven = hoursDriven;
    }

    public long getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public void setDriversLicenseNumber(long driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public String getMotorVehicleRecord() {
        return motorVehicleRecord;
    }

    public void setMotorVehicleRecord(String motorVehicleRecord) {
        this.motorVehicleRecord = motorVehicleRecord;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public String getTuesdayRoute() {
        return tuesdayRoute;
    }

    public void setTuesdayRoute(String tuesdayRoute) {
        this.tuesdayRoute = tuesdayRoute;
    }

    public String getWednesdayRoute() {
        return wednesdayRoute;
    }

    public void setWednesdayRoute(String wednesdayRoute) {
        this.wednesdayRoute = wednesdayRoute;
    }

    public String getThursdayRoute() {
        return thursdayRoute;
    }

    public void setThursdayRoute(String thursdayRoute) {
        this.thursdayRoute = thursdayRoute;
    }

    public String getFridayRoute() {
        return fridayRoute;
    }

    public void setFridayRoute(String fridayRoute) {
        this.fridayRoute = fridayRoute;
    }

    public Date getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public void setLicenseExpirationDate(Date licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public boolean isCdlCertified() {
        return isCdlCertified;
    }

    public void setCdlCertified(boolean cdlCertified) {
        isCdlCertified = cdlCertified;
    }

    public boolean isBackUpDriver() {
        return isBackUpDriver;
    }

    public void setBackUpDriver(boolean backUpDriver) {
        isBackUpDriver = backUpDriver;
    }
}
