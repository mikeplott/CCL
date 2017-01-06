package com.CCL.entities.products;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "beers")
public class Beer {

    public enum caseSize{
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

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private Timestamp lotDate;

    @Column(nullable = false)
    private Timestamp expirationDate;

    @Column(nullable = false)
    private String beerType;

    @Column(nullable = false)
    private String brewery;

    @Column(nullable = false)
    private boolean isDomestic;

    @Column(nullable = false)
    private boolean isSeasonal;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String itemCode;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String volume;

    @Column(nullable = false)
    private double frontPrice;

    @Column(nullable = false)
    private double tenCasePrice;

    @Column(nullable = false)
    private double twentyFiveCasePrice;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private double bottleWeight;

    @Column(nullable = false)
    private double caseWeight;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private boolean isExclusive;

    @Column(nullable = false)
    private boolean isDualState;

    @Column(nullable = false)
    private caseSize caseSize;

    public Beer() {
    }

    public Beer(Timestamp lotDate, Timestamp expirationDate, String beerType, String brewery, boolean isDomestic,
                boolean isSeasonal, String name, String description, String itemCode, String origin, String volume,
                double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight,
                double caseWeight, int quantity, boolean isExclusive, boolean isDualState, Beer.caseSize caseSize) {
        this.lotDate = lotDate;
        this.expirationDate = expirationDate;
        this.beerType = beerType;
        this.brewery = brewery;
        this.isDomestic = isDomestic;
        this.isSeasonal = isSeasonal;
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

    public Beer(int id, Timestamp lotDate, Timestamp expirationDate, String beerType, String brewery, boolean isDomestic,
                boolean isSeasonal, String name, String description, String itemCode, String origin, String volume,
                double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight,
                double caseWeight, int quantity, boolean isExclusive, boolean isDualState, Beer.caseSize caseSize) {
        this.id = id;
        this.lotDate = lotDate;
        this.expirationDate = expirationDate;
        this.beerType = beerType;
        this.brewery = brewery;
        this.isDomestic = isDomestic;
        this.isSeasonal = isSeasonal;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getLotDate() {
        return lotDate;
    }

    public void setLotDate(Timestamp lotDate) {
        this.lotDate = lotDate;
    }

    public Timestamp getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Timestamp expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBeerType() {
        return beerType;
    }

    public void setBeerType(String beerType) {
        this.beerType = beerType;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public boolean isDomestic() {
        return isDomestic;
    }

    public void setDomestic(boolean domestic) {
        isDomestic = domestic;
    }

    public boolean isSeasonal() {
        return isSeasonal;
    }

    public void setSeasonal(boolean seasonal) {
        isSeasonal = seasonal;
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

    public Beer.caseSize getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(Beer.caseSize caseSize) {
        this.caseSize = caseSize;
    }
}
