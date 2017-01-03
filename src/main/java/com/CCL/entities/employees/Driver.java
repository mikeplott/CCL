package com.CCL.entities.employees;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;

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
    private int productBreakage;

    @Column(nullable = false)
    private int hoursDriven;

    @Column(nullable = false)
    private long driversLicenseNumber;

    @Column(nullable = false)
    private ArrayList<String> movingViolations;

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
    private Timestamp licenseExpirationDate;

    @Column(nullable = false)
    private boolean cdlCertified;

    public Driver() {
    }

    public Driver(int productBreakage, int hoursDriven, long driversLicenseNumber, ArrayList<String> movingViolations,
                  String motorVehicleRecord, String insurancePolicyNumber, String tuesdayRoute, String wednesdayRoute,
                  String thursdayRoute, String fridayRoute, Timestamp licenseExpirationDate) {
        this.productBreakage = productBreakage;
        this.hoursDriven = hoursDriven;
        this.driversLicenseNumber = driversLicenseNumber;
        this.movingViolations = movingViolations;
        this.motorVehicleRecord = motorVehicleRecord;
        this.insurancePolicyNumber = insurancePolicyNumber;
        this.tuesdayRoute = tuesdayRoute;
        this.wednesdayRoute = wednesdayRoute;
        this.thursdayRoute = thursdayRoute;
        this.fridayRoute = fridayRoute;
        this.licenseExpirationDate = licenseExpirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<String> getMovingViolations() {
        return movingViolations;
    }

    public void setMovingViolations(ArrayList<String> movingViolations) {
        this.movingViolations = movingViolations;
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

    public Timestamp getLicenseExpirationDate() {
        return licenseExpirationDate;
    }

    public void setLicenseExpirationDate(Timestamp licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }
}
