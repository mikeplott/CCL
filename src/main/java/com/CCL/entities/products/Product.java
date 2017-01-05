package com.CCL.entities.products;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue
    int id;

    @Column()
    private int wineID;

    @Column()
    private int beerID;

    @Column()
    private int liquorID;

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
    private int vintage;

    @Column()
    private String varietal;

    @Column()
    private String color;

    @Column()
    private String importer;

    @Column()
    private Timestamp lotDate;

    @Column()
    private Timestamp expirationDate;

    @Column()
    private String beerType;

    @Column()
    private String brewery;

    @Column()
    private boolean isDomestic;

    @Column()
    private boolean isSeasonal;

    @Column()
    private String liquorType;

    @Column()
    private String distillery;

    @Column()
    private Wine.caseSize wineCaseSize;

    @Column()
    private Beer.caseSize beerCaseSize;

    @Column()
    private Liquor.caseSize liquorCaseSize;

    public Product() {
    }

    public Product(int wineID, String name, String description, String itemCode, String origin, String volume,
                   double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight,
                   double caseWeight, int quantity, boolean isExclusive, boolean isDualState, int vintage, String varietal,
                   String color, String importer, Wine.caseSize caseSize) {
        this.wineID = wineID;
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
        this.vintage = vintage;
        this.varietal = varietal;
        this.color = color;
        this.importer = importer;
        this.wineCaseSize = caseSize;
    }

    public Product(int beerID, String name, String description, String itemCode, String origin, String volume,
                   double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight,
                   double caseWeight, int quantity, boolean isExclusive, boolean isDualState, Timestamp lotDate,
                   Timestamp expirationDate, String beerType, String brewery, boolean isDomestic, boolean isSeasonal,
                   Beer.caseSize caseSize) {
        this.beerID = beerID;
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
        this.lotDate = lotDate;
        this.expirationDate = expirationDate;
        this.beerType = beerType;
        this.brewery = brewery;
        this.isDomestic = isDomestic;
        this.isSeasonal = isSeasonal;
        this.beerCaseSize = caseSize;
    }

    public Product(int liquorID, String name, String description, String itemCode, String origin, String volume,
                   double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight,
                   double caseWeight, int quantity, boolean isExclusive, boolean isDualState, String liquorType,
                   String distillery, Liquor.caseSize caseSize) {
        this.liquorID = liquorID;
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
        this.liquorType = liquorType;
        this.distillery = distillery;
        this.liquorCaseSize = caseSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWineID() {
        return wineID;
    }

    public void setWineID(int wineID) {
        this.wineID = wineID;
    }

    public int getBeerID() {
        return beerID;
    }

    public void setBeerID(int beerID) {
        this.beerID = beerID;
    }

    public int getLiquorID() {
        return liquorID;
    }

    public void setLiquorID(int liquorID) {
        this.liquorID = liquorID;
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

    public String getLiquorType() {
        return liquorType;
    }

    public void setLiquorType(String liquorType) {
        this.liquorType = liquorType;
    }

    public String getDistillery() {
        return distillery;
    }

    public void setDistillery(String distillery) {
        this.distillery = distillery;
    }

    public Wine.caseSize getWineCaseSize() {
        return wineCaseSize;
    }

    public void setWineCaseSize(Wine.caseSize wineCaseSize) {
        this.wineCaseSize = wineCaseSize;
    }

    public Beer.caseSize getBeerCaseSize() {
        return beerCaseSize;
    }

    public void setBeerCaseSize(Beer.caseSize beerCaseSize) {
        this.beerCaseSize = beerCaseSize;
    }

    public Liquor.caseSize getLiquorCaseSize() {
        return liquorCaseSize;
    }

    public void setLiquorCaseSize(Liquor.caseSize liquorCaseSize) {
        this.liquorCaseSize = liquorCaseSize;
    }

    public static Product createWineProduct(Wine wine) {
        Product product = new Product(wine.getId(), wine.getName(), wine.getDescription(), wine.getItemCode(), wine.getOrigin(),
                wine.getVolume(), wine.getFrontPrice(), wine.getTenCasePrice(), wine.getTwentyFiveCasePrice(), wine.getCost(),
                wine.getBottleWeight(), wine.getCaseWeight(), wine.getQuantity(), wine.isExclusive(), wine.isDualState(),
                wine.getVintage(), wine.getVarietal(), wine.getColor(), wine.getImporter(), wine.getcaseSize());

        return product;
    }

    public static Product createBeerProduct(Beer beer) {
        Product product = new Product(beer.getId(), beer.getName(), beer.getDescription(), beer.getItemCode(), beer.getOrigin(),
                beer.getVolume(), beer.getFrontPrice(), beer.getTenCasePrice(), beer.getTwentyFiveCasePrice(), beer.getCost(),
                beer.getBottleWeight(), beer.getCaseWeight(), beer.getQuantity(), beer.isExclusive(), beer.isDualState(),
                beer.getLotDate(), beer.getExpirationDate(), beer.getBeerType(), beer.getBrewery(), beer.isDomestic(),
                beer.isSeasonal(), beer.getCaseSize());

        return product;
    }

    public static Product createLiquorProduct(Liquor liquor) {
        Product product = new Product(liquor.getId(), liquor.getName(), liquor.getDescription(), liquor.getItemCode(),
                liquor.getOrigin(), liquor.getVolume(), liquor.getFrontPrice(), liquor.getTenCasePrice(), liquor.getTwentyFiveCasePrice(),
                liquor.getCost(), liquor.getBottleWeight(), liquor.getCaseWeight(), liquor.getQuantity(), liquor.isExclusive(),
                liquor.isDualState(), liquor.getLiquorType(), liquor.getDistillery(), liquor.getcaseSize());

        return product;
    }
}

