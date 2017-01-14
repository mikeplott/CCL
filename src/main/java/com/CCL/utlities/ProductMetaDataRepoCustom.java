package com.CCL.utlities;

/**
 * Created by michaelplott on 1/13/17.
 */

public interface ProductMetaDataRepoCustom {

    public void updateWineFields(String name, String description, String itemCode, String origin, String volume,
                                 String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
                                 String bottleWeight, String caseWeight, String quantity, String isExclusive,
                                 String isDualState, String caseSize, String vintage, String varietal, String color,
                                 String importer, String wineID, String id);

    public void updateBeerFields(String name, String description, String itemCode, String origin, String volume,
                                 String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
                                 String bottleWeight, String caseWeight, String quantity, String isExclusive,
                                 String isDualState, String caseSize, String lotDate, String expirationDate,
                                 String beerType, String brewery, String isDomestic, String isSeasonal, String beerID,
                                 String id);

    public void updateLiquorFields(String name, String description, String itemCode, String origin, String volume,
                                   String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
                                   String bottleWeight, String caseWeight, String quantity, String isExclusive,
                                   String isDualState, String caseSize, String liquorType, String distillery,
                                   String liquorID, String id);

}
