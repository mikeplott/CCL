package com.CCL.entities.fleet;

import javax.persistence.*;

/**
 * Created by michaelplott on 2/6/17.
 */
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private long mileage;

    @Column(nullable = false)
    private String fuelType;

    @Column(nullable = false)
    private String manufacturer;

    @Column
    private String warrantyInfo;

    @Column
    private String vin;

    @Column
    private String licensePlate;

    @Column
    private boolean cdlRequired;

    @Column
    private boolean isVan;

    @Column
    private boolean isTruck;

    @Column
    private boolean isCar;

    @Column
    private boolean hasRamp;

    @Column
    private boolean hasWarranty;

    public Vehicle() {
    }

    public Vehicle(String make, String model, int year, long mileage, String fuelType, String manufacturer,
                   String warrantyInfo, String vin, String licensePlate, boolean cdlRequired, boolean isVan,
                   boolean isTruck, boolean isCar, boolean hasRamp, boolean hasWarranty) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.fuelType = fuelType;
        this.manufacturer = manufacturer;
        this.warrantyInfo = warrantyInfo;
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.cdlRequired = cdlRequired;
        this.isVan = isVan;
        this.isTruck = isTruck;
        this.isCar = isCar;
        this.hasRamp = hasRamp;
        this.hasWarranty = hasWarranty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getMileage() {
        return mileage;
    }

    public void setMileage(long mileage) {
        this.mileage = mileage;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getWarrantyInfo() {
        return warrantyInfo;
    }

    public void setWarrantyInfo(String warrantyInfo) {
        this.warrantyInfo = warrantyInfo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isCdlRequired() {
        return cdlRequired;
    }

    public void setCdlRequired(boolean cdlRequired) {
        this.cdlRequired = cdlRequired;
    }

    public boolean isVan() {
        return isVan;
    }

    public void setVan(boolean van) {
        isVan = van;
    }

    public boolean isTruck() {
        return isTruck;
    }

    public void setTruck(boolean truck) {
        isTruck = truck;
    }

    public boolean isCar() {
        return isCar;
    }

    public void setCar(boolean car) {
        isCar = car;
    }

    public boolean isHasRamp() {
        return hasRamp;
    }

    public void setHasRamp(boolean hasRamp) {
        this.hasRamp = hasRamp;
    }

    public boolean isHasWarranty() {
        return hasWarranty;
    }

    public void setHasWarranty(boolean hasWarranty) {
        this.hasWarranty = hasWarranty;
    }
}
