package com.CCL.entities;

import javax.persistence.Column;

/**
 * Created by michaelplott on 1/3/17.
 */
public abstract class Product {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String itemCode;

    @Column(nullable = false)
    private int frontPrice;

    @Column(nullable = false)
    private int tenCasePrice;

    @Column(nullable = false)
    private int twentyFiveCasePrice;

    @Column(nullable = false)
    private int cost;



}
