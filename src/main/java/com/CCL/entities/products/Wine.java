package com.CCL.entities.products;

import javax.persistence.*;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "wines")
public class Wine extends Product {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int vintage;

    @Column(nullable = false)
    private String varietal;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String importer;


    public Wine() {
    }

    public Wine(String name, String description, String itemCode, String origin, String volume, double frontPrice,
                double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight, double caseWeight,
                int quantity, boolean isExclusive, boolean isDualState, int vintage, String varietal, String color,
                String importer, Product.caseSize caseSize) {
        super(name, description, itemCode, origin, volume, frontPrice, tenCasePrice, twentyFiveCasePrice, cost,
                bottleWeight, caseWeight, quantity, isExclusive, isDualState, caseSize);
        this.vintage = vintage;
        this.varietal = varietal;
        this.color = color;
        this.importer = importer;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVintage() {
        return vintage;
    }

    public void setVintage(int vintage) {
        this.vintage = vintage;
    }

    public String getVarietal() {
        return varietal;
    }

    public void setVarietal(String varietal) {
        this.varietal = varietal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImporter() {
        return importer;
    }

    public void setImporter(String importer) {
        this.importer = importer;
    }
}
//    public Wine(int vintage, String varietal, String color, String importer, String name, String description,
//                String itemCode, String origin, String volume, double frontPrice, double tenCasePrice,
//                double twentyFiveCasePrice, double cost, double bottleWeight, double caseWeight, int quantity,
//                boolean isExclusive, boolean isDualState, Wine.caseSize caseSize) {
//        this.vintage = vintage;
//        this.varietal = varietal;
//        this.color = color;
//        this.importer = importer;
//        this.name = name;
//        this.description = description;
//        this.itemCode = itemCode;
//        this.origin = origin;
//        this.volume = volume;
//        this.frontPrice = frontPrice;
//        this.tenCasePrice = tenCasePrice;
//        this.twentyFiveCasePrice = twentyFiveCasePrice;
//        this.cost = cost;
//        this.bottleWeight = bottleWeight;
//        this.caseWeight = caseWeight;
//        this.quantity = quantity;
//        this.isExclusive = isExclusive;
//        this.isDualState = isDualState;
//        this.caseSize = caseSize;
//    }
//
//    public Wine(int id, int vintage, String varietal, String color, String importer, String name, String description,
//                String itemCode, String origin, String volume, double frontPrice, double tenCasePrice, double twentyFiveCasePrice,
//                double cost, double bottleWeight, double caseWeight, int quantity, boolean isExclusive, boolean isDualState,
//                Wine.caseSize caseSize) {
//        this.id = id;
//        this.vintage = vintage;
//        this.varietal = varietal;
//        this.color = color;
//        this.importer = importer;
//        this.name = name;
//        this.description = description;
//        this.itemCode = itemCode;
//        this.origin = origin;
//        this.volume = volume;
//        this.frontPrice = frontPrice;
//        this.tenCasePrice = tenCasePrice;
//        this.twentyFiveCasePrice = twentyFiveCasePrice;
//        this.cost = cost;
//        this.bottleWeight = bottleWeight;
//        this.caseWeight = caseWeight;
//        this.quantity = quantity;
//        this.isExclusive = isExclusive;
//        this.isDualState = isDualState;
//        this.caseSize = caseSize;
//    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getVintage() {
//        return vintage;
//    }
//
//    public void setVintage(int vintage) {
//        this.vintage = vintage;
//    }
//
//    public String getVarietal() {
//        return varietal;
//    }
//
//    public void setVarietal(String varietal) {
//        this.varietal = varietal;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public String getImporter() {
//        return importer;
//    }
//
//    public void setImporter(String importer) {
//        this.importer = importer;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getItemCode() {
//        return itemCode;
//    }
//
//    public void setItemCode(String itemCode) {
//        this.itemCode = itemCode;
//    }
//
//    public String getOrigin() {
//        return origin;
//    }
//
//    public void setOrigin(String origin) {
//        this.origin = origin;
//    }
//
//    public String getVolume() {
//        return volume;
//    }
//
//    public void setVolume(String volume) {
//        this.volume = volume;
//    }
//
//    public double getFrontPrice() {
//        return frontPrice;
//    }
//
//    public void setFrontPrice(double frontPrice) {
//        this.frontPrice = frontPrice;
//    }
//
//    public double getTenCasePrice() {
//        return tenCasePrice;
//    }
//
//    public void setTenCasePrice(double tenCasePrice) {
//        this.tenCasePrice = tenCasePrice;
//    }
//
//    public double getTwentyFiveCasePrice() {
//        return twentyFiveCasePrice;
//    }
//
//    public void setTwentyFiveCasePrice(double twentyFiveCasePrice) {
//        this.twentyFiveCasePrice = twentyFiveCasePrice;
//    }
//
//    public double getCost() {
//        return cost;
//    }
//
//    public void setCost(double cost) {
//        this.cost = cost;
//    }
//
//    public double getBottleWeight() {
//        return bottleWeight;
//    }
//
//    public void setBottleWeight(double bottleWeight) {
//        this.bottleWeight = bottleWeight;
//    }
//
//    public double getCaseWeight() {
//        return caseWeight;
//    }
//
//    public void setCaseWeight(double caseWeight) {
//        this.caseWeight = caseWeight;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    public boolean isExclusive() {
//        return isExclusive;
//    }
//
//    public void setExclusive(boolean exclusive) {
//        isExclusive = exclusive;
//    }
//
//    public boolean isDualState() {
//        return isDualState;
//    }
//
//    public void setDualState(boolean dualState) {
//        isDualState = dualState;
//    }
//
//    public Wine.caseSize getcaseSize() {
//        return caseSize;
//    }
//
//    public void setcaseSize(Wine.caseSize caseSize) {
//        this.caseSize = caseSize;
//    }
//}

//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private String description;
//
//    @Column(nullable = false)
//    private String itemCode;
//
//    @Column(nullable = false)
//    private String origin;
//
//    @Column(nullable = false)
//    private String volume;
//
//    @Column(nullable = false)
//    private double frontPrice;
//
//    @Column(nullable = false)
//    private double tenCasePrice;
//
//    @Column(nullable = false)
//    private double twentyFiveCasePrice;
//
//    @Column(nullable = false)
//    private double cost;
//
//    @Column(nullable = false)
//    private double bottleWeight;
//
//    @Column(nullable = false)
//    private double caseWeight;
//
//    @Column(nullable = false)
//    private int quantity;
//
//    @Column(nullable = false)
//    private boolean isExclusive;
//
//    @Column(nullable = false)
//    private boolean isDualState;
//
//    @Column(nullable = false)
//    private caseSize caseSize;

