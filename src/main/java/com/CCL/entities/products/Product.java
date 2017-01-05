package com.CCL.entities.products;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "products")
public class Product {

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

    @Id
    @GeneratedValue
    int id;

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
    private static caseSize caseSize;

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

    public Product() {
    }

    public Product(String name, String description, String itemCode, String origin, String volume, double frontPrice,
                   double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight, double caseWeight,
                   int quantity, boolean isExclusive, boolean isDualState, Product.caseSize caseSize, int vintage,
                   String varietal, String color, String importer, Timestamp lotDate, Timestamp expirationDate,
                   String beerType, String brewery, boolean isDomestic, boolean isSeasonal, String liquorType,
                   String distillery) {
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
        this.vintage = vintage;
        this.varietal = varietal;
        this.color = color;
        this.importer = importer;
        this.lotDate = lotDate;
        this.expirationDate = expirationDate;
        this.beerType = beerType;
        this.brewery = brewery;
        this.isDomestic = isDomestic;
        this.isSeasonal = isSeasonal;
        this.liquorType = liquorType;
        this.distillery = distillery;
    }

    public Product(String name, String description, String itemCode, String origin, String volume, double frontPrice,
                   double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight, double caseWeight,
                   int quantity, boolean isExclusive, boolean isDualState, Product.caseSize caseSize, int vintage,
                   String varietal, String color, String importer) {
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
        this.vintage = vintage;
        this.varietal = varietal;
        this.color = color;
        this.importer = importer;
    }

    public Product(int id, String name, String description, String itemCode, String origin, String volume, double frontPrice,
                   double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight, double caseWeight,
                   int quantity, boolean isExclusive, boolean isDualState, Product.caseSize caseSize, Timestamp lotDate,
                   Timestamp expirationDate, String beerType, String brewery, boolean isDomestic, boolean isSeasonal) {
        this.id = id;
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
        this.lotDate = lotDate;
        this.expirationDate = expirationDate;
        this.beerType = beerType;
        this.brewery = brewery;
        this.isDomestic = isDomestic;
        this.isSeasonal = isSeasonal;
    }

    public Product(int id, String name, String description, String itemCode, String origin, String volume, double frontPrice,
                   double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight, double caseWeight,
                   int quantity, boolean isExclusive, boolean isDualState, Product.caseSize caseSize, String liquorType,
                   String distillery) {
        this.id = id;
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
        this.liquorType = liquorType;
        this.distillery = distillery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static Product createWineProduct(Wine wine) {
        Product product = new Product(wine.getName(), wine.getDescription(), wine.getItemCode(), wine.getOrigin(), wine.getVolume(),
                wine.getFrontPrice(), wine.getTenCasePrice(), wine.getTwentyFiveCasePrice(), wine.getCost(), wine.getBottleWeight(),
                wine.getCaseWeight(), wine.getQuantity(), wine.isExclusive(), wine.isDualState(), null, wine.getVintage(),
                wine.getVarietal(), wine.getColor(), wine.getImporter());

        int enumValues = Wine.caseSize.values().length;
        int theNum = wine.getcaseSize().ordinal();
        product = findCaseSize(enumValues, theNum, product);
        //ProductsController.products.save(product);
        return product;
    }

    public static Product findCaseSize(int enumValues, int theNum, Product product) {
        for (int i = 0; i < enumValues + 1; i++) {
            if (theNum == 0) {
                product.setCaseSize(Product.caseSize.ONE_PACK);
                return product;
            }
            if (theNum == 1) {
                product.setCaseSize(Product.caseSize.THREE_PACK);
                return product;
            }
            if (theNum == 2) {
                product.setCaseSize(Product.caseSize.SIX_PACK);
                return product;
            }
            if (theNum == 3) {
                product.setCaseSize(Product.caseSize.NINE_PACK);
                return product;
            }
            if (theNum == 4) {
                product.setCaseSize(Product.caseSize.TWELVE_PACK);
                return product;
            }
            if (theNum == 5) {
                product.setCaseSize(Product.caseSize.TWENTY_FOUR_PACK);
                return product;
            }
            if (theNum == 6) {
                product.setCaseSize(Product.caseSize.FIVE_SEVENTEEN_GAL_KEG);
                return product;
            }
            if (theNum == 7) {
                product.setCaseSize(Product.caseSize.SEVEN_SEVEN_FIVE_GAL_KEG);
                return product;
            }
            if (theNum == 8) {
                product.setCaseSize(Product.caseSize.FIFTEEN_FIVE_GAL_KEG);
                return product;
            }
            if (theNum == 9) {
                product.setCaseSize(Product.caseSize.TWENTY_LITRE_KEG);
                return product;
            }
            if (theNum == 10) {
                product.setCaseSize(Product.caseSize.FIFTY_LITRE_KEG);
                return product;
            }
        }
        return product;
    }
}

