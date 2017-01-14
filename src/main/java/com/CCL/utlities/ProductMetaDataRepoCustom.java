package com.CCL.utlities;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by michaelplott on 1/13/17.
 */
public interface ProductMetaDataRepoCustom {
    public void updateWineFields(String name, String description, String itemCode, String origin, String volume,
                                 String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
                                 String bottleWeight, String caseWeight, String quantity, String isExclusive,
                                 String isDualState, String caseSize, String vintage, String varietal, String color,
                                 String importer, String wineID, String id);

}
