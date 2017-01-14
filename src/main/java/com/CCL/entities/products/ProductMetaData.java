package com.CCL.entities.products;

import javax.persistence.*;

/**
 * Created by michaelplott on 1/13/17.
 */

@Entity
@Table(name = "products")
public class ProductMetaData {

    @Id
    @GeneratedValue
    private String id;

    @Column()
    private String beerID;

    @Column()
    private String liquorID;

    @Column()
    private String wineID;

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
    private String frontPrice;

    @Column()
    private String tenCasePrice;

    @Column()
    private String twentyFiveCasePrice;

    @Column()
    private String cost;

    @Column()
    private String bottleWeight;

    @Column()
    private String caseWeight;

    @Column()
    private String quantity;

    @Column()
    private String isExclusive;

    @Column()
    private String isDualState;

    @Column()
    private String vintage;

    @Column()
    private String varietal;

    @Column()
    private String color;

    @Column()
    private String importer;

    @Column()
    private String lotDate;

    @Column()
    private String expirationDate;

    @Column()
    private String beerType;

    @Column()
    private String brewery;

    @Column()
    private String isDomestic;

    @Column()
    private String isSeasonal;

    @Column()
    private String liquorType;

    @Column()
    private String distillery;

    @Column()
    private String caseSize;

    public ProductMetaData() {
    }

    public ProductMetaData(String beerID, String name, String description, String itemCode, String origin,
                           String volume, String frontPrice, String tenCasePrice, String twentyFiveCasePrice,
                           String cost, String bottleWeight, String caseWeight, String quantity, String isExclusive,
                           String isDualState, String lotDate, String expirationDate, String beerType, String brewery,
                           String isDomestic, String isSeasonal, String caseSize) {
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
        this.caseSize = caseSize;
    }

    public ProductMetaData(String wineID, String name, String description, String itemCode, String origin, String volume,
                           String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost, String bottleWeight,
                           String caseWeight, String quantity, String isEclusive, String isDualState, String vintage,
                           String varietal, String color, String importer, String caseSize) {
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
        this.isExclusive = isEclusive;
        this.isDualState = isDualState;
        this.vintage = vintage;
        this.varietal = varietal;
        this.color = color;
        this.importer = importer;
        this.caseSize = caseSize;
    }

    public ProductMetaData(String liquorID, String name, String description, String itemCode, String origin, String volume,
                           String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost, String bottleWeight,
                           String caseWeight, String quantity, String isEclusive, String isDualState, String liquorType,
                           String distillery, String caseSize) {
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
        this.isExclusive = isEclusive;
        this.isDualState = isDualState;
        this.liquorType = liquorType;
        this.distillery = distillery;
        this.caseSize = caseSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBeerID() {
        return beerID;
    }

    public void setBeerID(String beerID) {
        this.beerID = beerID;
    }

    public String getLiquorID() {
        return liquorID;
    }

    public void setLiquorID(String liquorID) {
        this.liquorID = liquorID;
    }

    public String getWineID() {
        return wineID;
    }

    public void setWineID(String wineID) {
        this.wineID = wineID;
    }

    public String getIsExclusive() {
        return isExclusive;
    }

    public void setIsExclusive(String isExclusive) {
        this.isExclusive = isExclusive;
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

    public String getFrontPrice() {
        return frontPrice;
    }

    public void setFrontPrice(String frontPrice) {
        this.frontPrice = frontPrice;
    }

    public String getTenCasePrice() {
        return tenCasePrice;
    }

    public void setTenCasePrice(String tenCasePrice) {
        this.tenCasePrice = tenCasePrice;
    }

    public String getTwentyFiveCasePrice() {
        return twentyFiveCasePrice;
    }

    public void setTwentyFiveCasePrice(String twentyFiveCasePrice) {
        this.twentyFiveCasePrice = twentyFiveCasePrice;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getBottleWeight() {
        return bottleWeight;
    }

    public void setBottleWeight(String bottleWeight) {
        this.bottleWeight = bottleWeight;
    }

    public String getCaseWeight() {
        return caseWeight;
    }

    public void setCaseWeight(String caseWeight) {
        this.caseWeight = caseWeight;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getIsEclusive() {
        return isExclusive;
    }

    public void setIsEclusive(String isEclusive) {
        this.isExclusive = isEclusive;
    }

    public String getIsDualState() {
        return isDualState;
    }

    public void setIsDualState(String isDualState) {
        this.isDualState = isDualState;
    }

    public String getVintage() {
        return vintage;
    }

    public void setVintage(String vintage) {
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

    public String getLotDate() {
        return lotDate;
    }

    public void setLotDate(String lotDate) {
        this.lotDate = lotDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
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

    public String getIsDomestic() {
        return isDomestic;
    }

    public void setIsDomestic(String isDomestic) {
        this.isDomestic = isDomestic;
    }

    public String getIsSeasonal() {
        return isSeasonal;
    }

    public void setIsSeasonal(String isSeasonal) {
        this.isSeasonal = isSeasonal;
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

    public String getCaseSize() {
        return caseSize;
    }

    public void setCaseSize(String caseSize) {
        this.caseSize = caseSize;
    }

    public static ProductMetaData createWineProduct(Wine wine) {
        ProductMetaData product = new ProductMetaData(String.valueOf(wine.getId()), wine.getName(),
                wine.getDescription(), String.valueOf(wine.getItemCode()), wine.getOrigin(), wine.getVolume(),
                String.valueOf(wine.getFrontPrice()), String.valueOf(wine.getTenCasePrice()),
                String.valueOf(wine.getTwentyFiveCasePrice()), String.valueOf(wine.getCost()),
                String.valueOf(wine.getBottleWeight()), String.valueOf(wine.getCaseWeight()),
                String.valueOf(wine.getQuantity()), String.valueOf(wine.isExclusive()),
                String.valueOf(wine.isDualState()), String.valueOf(wine.getVintage()),
                wine.getVarietal(), wine.getColor(), wine.getImporter(), wine.getCaseSize().name());

        return product;
    }

    public static ProductMetaData createBeerProduct(Beer beer) {
        ProductMetaData product = new ProductMetaData(String.valueOf(beer.getId()), beer.getName(),
                beer.getDescription(), String.valueOf(beer.getItemCode()), beer.getOrigin(), beer.getVolume(),
                String.valueOf(beer.getFrontPrice()), String.valueOf(beer.getTenCasePrice()),
                String.valueOf(beer.getTwentyFiveCasePrice()), String.valueOf(beer.getCost()),
                String.valueOf(beer.getBottleWeight()), String.valueOf(beer.getCaseWeight()),
                String.valueOf(beer.getQuantity()), String.valueOf(beer.isExclusive()),
                String.valueOf(beer.isDualState()), String.valueOf(beer.getLotDate()),
                String.valueOf(beer.getExpirationDate()), beer.getBeerType(), beer.getBrewery(),
                String.valueOf(beer.isDomestic()), String.valueOf(beer.isSeasonal()),
                beer.getCaseSize().name());

        return product;
    }

    public static ProductMetaData createLiquorProduct(Liquor liquor) {
        ProductMetaData product = new ProductMetaData(String.valueOf(liquor.getId()), liquor.getName(),
                liquor.getDescription(), String.valueOf(liquor.getItemCode()), liquor.getOrigin(), liquor.getVolume(),
                String.valueOf(liquor.getFrontPrice()), String.valueOf(liquor.getTenCasePrice()),
                String.valueOf(liquor.getTwentyFiveCasePrice()), String.valueOf(liquor.getCost()),
                String.valueOf(liquor.getBottleWeight()), String.valueOf(liquor.getCaseWeight()),
                String.valueOf(liquor.getQuantity()), String.valueOf(liquor.isExclusive()),
                String.valueOf(liquor.isDualState()), String.valueOf(liquor.getLiquorType()),
                String.valueOf(liquor.getDistillery()), liquor.getCaseSize().name());

        return product;
    }
}
