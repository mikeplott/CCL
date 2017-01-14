package com.CCL.utlities;

import com.CCL.entities.products.Wine;

/**
 * Created by michaelplott on 1/13/17.
 */
public interface WineRepoCustom {

    public void wineUpdater(String name, String description, String itemCode, String origin, String volume,
                            double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost,
                            double bottleWeight, double caseWeight, int quantity, boolean isExclusive,
                            boolean isDualState, Wine.caseSize caseSize , int vintage, String varietal, String color,
                            String importer, int wineID);
}
