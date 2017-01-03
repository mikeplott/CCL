package com.CCL.entities.products;

import javax.persistence.*;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "wines")
public class Wine {

    public enum wineCaseSize{
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
    private int vintage;

    @Column(nullable = false)
    private String varietal;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private String importer;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String itemCode;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private int volume;

    @Column(nullable = false)
    private double frontPrice;

    @Column(nullable = false)
    private double tenCasePrice;

    @Column(nullable = false)
    private double twentyFiveCasePrice;

    @Column(nullable = false)
    private double cost;

    @Column(nullable = false)
    private int bottleWeight;

    @Column(nullable = false)
    private int caseWeight;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private boolean isExclusive;

    @Column(nullable = false)
    private boolean isDualState;

    @Column(nullable = false)
    private wineCaseSize wineCaseSize;

    public Wine() {
    }

    public Wine(int vintage, String varietal, String color, String importer, String name, String description,
                String itemCode, String origin, int volume, double frontPrice, double tenCasePrice,
                double twentyFiveCasePrice, double cost, int bottleWeight, int caseWeight, int quantity,
                boolean isExclusive, boolean isDualState, Wine.wineCaseSize wineCaseSize) {
        this.vintage = vintage;
        this.varietal = varietal;
        this.color = color;
        this.importer = importer;
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
        this.wineCaseSize = wineCaseSize;
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
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

    public int getBottleWeight() {
        return bottleWeight;
    }

    public void setBottleWeight(int bottleWeight) {
        this.bottleWeight = bottleWeight;
    }

    public int getCaseWeight() {
        return caseWeight;
    }

    public void setCaseWeight(int caseWeight) {
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

    public Wine.wineCaseSize getWineCaseSize() {
        return wineCaseSize;
    }

    public void setWineCaseSize(Wine.wineCaseSize wineCaseSize) {
        this.wineCaseSize = wineCaseSize;
    }
}
