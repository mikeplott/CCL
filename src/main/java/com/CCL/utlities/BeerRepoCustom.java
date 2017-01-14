package com.CCL.utlities;

import com.CCL.entities.products.Beer;

import java.sql.Date;

/**
 * Created by michaelplott on 1/13/17.
 */
public interface BeerRepoCustom {

    public void beerUpdate(String name, String description, String itemCode, String origin, String volume,
                           double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost,
                           double bottleWeight, double caseWeight, int quantity, boolean isExclusive,
                           boolean sDualState, Beer.caseSize caseSize, Date lotDate, Date expirationDate,
                           String beerType, String brewery, boolean isDomestic, boolean isSeasonal, int id);
}
