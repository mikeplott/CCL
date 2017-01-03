package com.CCL.entities.products;

import javax.persistence.Column;

/**
 * Created by michaelplott on 1/3/17.
 */
public abstract class Product {

    private enum caseSize{
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
        FIFTY_LITRE_KEG,
        FIRKIN;
    }

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
    private int frontPrice;

    @Column(nullable = false)
    private int tenCasePrice;

    @Column(nullable = false)
    private int twentyFiveCasePrice;

    @Column(nullable = false)
    private int cost;

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
    private caseSize caseSize;

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

    public int getFrontPrice() {
        return frontPrice;
    }

    public void setFrontPrice(int frontPrice) {
        this.frontPrice = frontPrice;
    }

    public int getTenCasePrice() {
        return tenCasePrice;
    }

    public void setTenCasePrice(int tenCasePrice) {
        this.tenCasePrice = tenCasePrice;
    }

    public int getTwentyFiveCasePrice() {
        return twentyFiveCasePrice;
    }

    public void setTwentyFiveCasePrice(int twentyFiveCasePrice) {
        this.twentyFiveCasePrice = twentyFiveCasePrice;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
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

    public Product.caseSize getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(Product.caseSize caseSize) {
        this.caseSize = caseSize;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public void setExclusive(boolean exclusive) {
        isExclusive = exclusive;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public boolean isDualState() {
        return isDualState;
    }

    public void setDualState(boolean dualState) {
        isDualState = dualState;
    }
}
