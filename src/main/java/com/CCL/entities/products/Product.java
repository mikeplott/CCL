//package com.CCL.entities.products;
//
//import javax.persistence.Column;
//import java.math.BigDecimal;
//
///**
// * Created by michaelplott on 1/3/17.
// */
//public abstract class Product {
//
//    private enum caseSize{
//        ONE_PACK,
//        THREE_PACK,
//        SIX_PACK,
//        NINE_PACK,
//        TWELVE_PACK,
//        TWENTY_FOUR_PACK,
//        FIVE_SEVENTEEN_GAL_KEG,
//        SEVEN_SEVEN_FIVE_GAL_KEG,
//        FIFTEEN_FIVE_GAL_KEG,
//        TWENTY_LITRE_KEG,
//        FIFTY_LITRE_KEG;
//    }
//
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
//    private int volume;
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
//    private int bottleWeight;
//
//    @Column(nullable = false)
//    private int caseWeight;
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
//    private static caseSize caseSize;
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
//    public int getVolume() {
//        return volume;
//    }
//
//    public void setVolume(int volume) {
//        this.volume = volume;
//    }
//
//    public BigDecimal getFrontPrice() {
//        return frontPrice;
//    }
//
//    public void setFrontPrice(BigDecimal frontPrice) {
//        this.frontPrice = frontPrice;
//    }
//
//    public BigDecimal getTenCasePrice() {
//        return tenCasePrice;
//    }
//
//    public void setTenCasePrice(BigDecimal tenCasePrice) {
//        this.tenCasePrice = tenCasePrice;
//    }
//
//    public BigDecimal getTwentyFiveCasePrice() {
//        return twentyFiveCasePrice;
//    }
//
//    public void setTwentyFiveCasePrice(BigDecimal twentyFiveCasePrice) {
//        this.twentyFiveCasePrice = twentyFiveCasePrice;
//    }
//
//    public BigDecimal getCost() {
//        return cost;
//    }
//
//    public void setCost(BigDecimal cost) {
//        this.cost = cost;
//    }
//
//    public int getBottleWeight() {
//        return bottleWeight;
//    }
//
//    public void setBottleWeight(int bottleWeight) {
//        this.bottleWeight = bottleWeight;
//    }
//
//    public int getCaseWeight() {
//        return caseWeight;
//    }
//
//    public void setCaseWeight(int caseWeight) {
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
//    public Product.caseSize getCaseSize() {
//        return caseSize;
//    }
//
//    public void setCaseSize(Product.caseSize caseSize) {
//        this.caseSize = caseSize;
//    }
//}
