package com.CCL.entities.products;

import javax.persistence.*;

/**
 * Created by michaelplott on 1/3/17.
 */
@Entity
@Table(name = "products")
public class Product {

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
    private int volume;

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
}
