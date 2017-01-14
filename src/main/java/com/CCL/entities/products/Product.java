package com.CCL.entities.products;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by michaelplott on 1/3/17.
 */
@MappedSuperclass
public abstract class Product {

    public enum caseSize {
        ONE_PACK,
        THREE_PACK,
        SIX_PACK,
        NINE_PACK,
        TWELVE_PACK,
        TWENTY_FOUR_PACK,
        FIVE_SEVENTEEN_GAL_KEG,
        SEVEN_SEVEN_FIVE_GAL_KEG,
        FIFTEEN_FIVE_GAL_KEG,
        TWENTY_LITRE_KEG,
        FIFTY_LITRE_KEG;
    }


    @Column()
    private String name;

    @Column()
    private String description;

    @Column()
    private String itemCode;

    @Column()
    private String origin;

    @Column()
    private String volume;

    @Column()
    private double frontPrice;

    @Column()
    private double tenCasePrice;

    @Column()
    private double twentyFiveCasePrice;

    @Column()
    private double cost;

    @Column()
    private double bottleWeight;

    @Column()
    private double caseWeight;

    @Column()
    private int quantity;

    @Column()
    private boolean isExclusive;

    @Column()
    private boolean isDualState;

    @Column()
    private caseSize caseSize;

    public Product() {
    }

    public Product(String name, String description, String itemCode, String origin, String volume, double frontPrice,
                   double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight, double caseWeight,
                   int quantity, boolean isExclusive, boolean isDualState, caseSize caseSize) {
        this.name = name;
        this.description = description;
        this.itemCode = itemCode;
        this.origin = origin;
        this.volume = volume;
        this.frontPrice = frontPrice;
        this.tenCasePrice = tenCasePrice;
        this.twentyFiveCasePrice = twentyFiveCasePrice;
        this.cost = cost;
        this.bottleWeight = bottleWeight;
        this.caseWeight = caseWeight;
        this.quantity = quantity;
        this.isExclusive = isExclusive;
        this.isDualState = isDualState;
        this.caseSize = caseSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public double getFrontPrice() {
        return frontPrice;
    }

    public void setFrontPrice(double frontPrice) {
        this.frontPrice = frontPrice;
    }

    public double getTenCasePrice() {
        return tenCasePrice;
    }

    public void setTenCasePrice(double tenCasePrice) {
        this.tenCasePrice = tenCasePrice;
    }

    public double getTwentyFiveCasePrice() {
        return twentyFiveCasePrice;
    }

    public void setTwentyFiveCasePrice(double twentyFiveCasePrice) {
        this.twentyFiveCasePrice = twentyFiveCasePrice;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getBottleWeight() {
        return bottleWeight;
    }

    public void setBottleWeight(double bottleWeight) {
        this.bottleWeight = bottleWeight;
    }

    public double getCaseWeight() {
        return caseWeight;
    }

    public void setCaseWeight(double caseWeight) {
        this.caseWeight = caseWeight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public void setExclusive(boolean exclusive) {
        isExclusive = exclusive;
    }

    public boolean isDualState() {
        return isDualState;
    }

    public void setDualState(boolean dualState) {
        isDualState = dualState;
    }

    public Product.caseSize getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(Product.caseSize caseSize) {
        this.caseSize = caseSize;
    }
}