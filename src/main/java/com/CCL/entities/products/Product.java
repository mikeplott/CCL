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


    //    @Id
//    @GeneratedValue
//    int id;

//    @Column()
//    private Integer wineID;
//
//    @Column()
//    private Integer beerID;
//
//    @Column()
//    private Integer liquorID;


//    @Column()
//    private int vintage;
//
//    @Column()
//    private String varietal;
//
//    @Column()
//    private String color;

//    @Column()
//    private String importer;

//    @Column()
//    private Date lotDate;
//
//    @Column()
//    private Date expirationDate;

//    @Column()
//    private String beerType;
//
//    @Column()
//    private String brewery;

//    @Column()
//    private boolean isDomestic;
//
//    @Column()
//    private boolean isSeasonal;

//    @Column()
//    private String liquorType;
//
//    @Column()
//    private String distillery;
//
//    @Column()
//    private Wine.caseSize wineCaseSize;
//
//    @Column()
//    private Beer.caseSize beerCaseSize;
//
//    @Column()
//    private Liquor.caseSize liquorCaseSize;
//
//    @Column()
//    private boolean isBeer;
//
//    @Column()
//    private boolean isLiquor;
//
//    @Column()
//    private boolean isWine;



//    public Product(Integer wineID, String name, String description, String itemCode, String origin, String volume,
//                   double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight,
//                   double caseWeight, int quantity, boolean isExclusive, boolean isDualState, int vintage, String varietal,
//                   String color, String importer, Wine.caseSize caseSize, boolean isBeer, boolean isLiquor, boolean isWine) {
//        this.wineID = wineID;
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
//        this.vintage = vintage;
//        this.varietal = varietal;
//        this.color = color;
//        this.importer = importer;
//        this.wineCaseSize = caseSize;
//        this.isBeer = isBeer;
//        this.isLiquor = isLiquor;
//        this.isWine = isWine;
//    }
//
//    public Product(Integer beerID, String name, String description, String itemCode, String origin, String volume,
//                   double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight,
//                   double caseWeight, int quantity, boolean isExclusive, boolean isDualState, Date lotDate,
//                   Date expirationDate, String beerType, String brewery, boolean isDomestic, boolean isSeasonal,
//                   Beer.caseSize caseSize, boolean isBeer, boolean isLiquor, boolean isWine) {
//        this.beerID = beerID;
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
//        this.lotDate = lotDate;
//        this.expirationDate = expirationDate;
//        this.beerType = beerType;
//        this.brewery = brewery;
//        this.isDomestic = isDomestic;
//        this.isSeasonal = isSeasonal;
//        this.beerCaseSize = caseSize;
//        this.isBeer = isBeer;
//        this.isLiquor = isLiquor;
//        this.isWine = isWine;
//    }
//
//    public Product(Integer liquorID, String name, String description, String itemCode, String origin, String volume,
//                   double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight,
//                   double caseWeight, int quantity, boolean isExclusive, boolean isDualState, String liquorType,
//                   String distillery, Liquor.caseSize caseSize, boolean isBeer, boolean isLiquor, boolean isWine) {
//        this.liquorID = liquorID;
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
//        this.liquorType = liquorType;
//        this.distillery = distillery;
//        this.liquorCaseSize = caseSize;
//        this.isBeer = isBeer;
//        this.isLiquor = isLiquor;
//        this.isWine = isWine;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Integer getWineID() {
//        return wineID;
//    }
//
//    public void setWineID(Integer wineID) {
//        this.wineID = wineID;
//    }
//
//    public Integer getBeerID() {
//        return beerID;
//    }
//
//    public void setBeerID(Integer beerID) {
//        this.beerID = beerID;
//    }
//
//    public Integer getLiquorID() {
//        return liquorID;
//    }
//
//    public void setLiquorID(Integer liquorID) {
//        this.liquorID = liquorID;
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
//    public Date getLotDate() {
//        return lotDate;
//    }
//
//    public void setLotDate(Date lotDate) {
//        this.lotDate = lotDate;
//    }
//
//    public Date getExpirationDate() {
//        return expirationDate;
//    }
//
//    public void setExpirationDate(Date expirationDate) {
//        this.expirationDate = expirationDate;
//    }
//
//    public String getBeerType() {
//        return beerType;
//    }
//
//    public void setBeerType(String beerType) {
//        this.beerType = beerType;
//    }
//
//    public String getBrewery() {
//        return brewery;
//    }
//
//    public void setBrewery(String brewery) {
//        this.brewery = brewery;
//    }
//
//    public boolean isDomestic() {
//        return isDomestic;
//    }
//
//    public void setDomestic(boolean domestic) {
//        isDomestic = domestic;
//    }
//
//    public boolean isSeasonal() {
//        return isSeasonal;
//    }
//
//    public void setSeasonal(boolean seasonal) {
//        isSeasonal = seasonal;
//    }
//
//    public String getLiquorType() {
//        return liquorType;
//    }
//
//    public void setLiquorType(String liquorType) {
//        this.liquorType = liquorType;
//    }
//
//    public String getDistillery() {
//        return distillery;
//    }
//
//    public void setDistillery(String distillery) {
//        this.distillery = distillery;
//    }
//
//    public Wine.caseSize getWineCaseSize() {
//        return wineCaseSize;
//    }
//
//    public void setWineCaseSize(Wine.caseSize wineCaseSize) {
//        this.wineCaseSize = wineCaseSize;
//    }
//
//    public Beer.caseSize getBeerCaseSize() {
//        return beerCaseSize;
//    }
//
//    public void setBeerCaseSize(Beer.caseSize beerCaseSize) {
//        this.beerCaseSize = beerCaseSize;
//    }
//
//    public Liquor.caseSize getLiquorCaseSize() {
//        return liquorCaseSize;
//    }
//
//    public void setLiquorCaseSize(Liquor.caseSize liquorCaseSize) {
//        this.liquorCaseSize = liquorCaseSize;
//    }
//
//    public boolean isBeer() {
//        return isBeer;
//    }
//
//    public void setBeer(boolean beer) {
//        isBeer = beer;
//    }
//
//    public boolean isLiquor() {
//        return isLiquor;
//    }
//
//    public void setLiquor(boolean liquor) {
//        isLiquor = liquor;
//    }
//
//    public boolean isWine() {
//        return isWine;
//    }
//
//    public void setWine(boolean wine) {
//        isWine = wine;
//    }