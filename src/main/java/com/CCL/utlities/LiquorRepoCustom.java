package com.CCL.utlities;

import com.CCL.entities.products.Liquor;

/**
 * Created by michaelplott on 1/13/17.
 */
public interface LiquorRepoCustom {

    public void liquorUpdater(String name, String description, String itemCode, String origin, String volume,
                              double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost,
                              double bottleWeight, double caseWeight, int quantity, boolean isExclusive,
                              boolean isDualState, Liquor.caseSize caseSize, String liquorType, String distillery,
                              int liquorID);
}
