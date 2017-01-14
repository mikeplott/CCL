package com.CCL.utlities;

import com.CCL.services.ProductMetaDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by michaelplott on 1/13/17.
 */
@Service
@Transactional(readOnly = false)
public class ProductMetaDataRepoImpl implements ProductMetaDataRepoCustom {

    @Autowired
    ProductMetaDataRepo products;

    @Override
    public void updateWineFields(String name, String description, String itemCode, String origin, String volume,
                                 String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
                                 String bottleWeight, String caseWeight, String quantity, String isExclusive,
                                 String isDualState, String caseSize, String vintage, String varietal, String color,
                                 String importer, String wineID, String id) {

    }

    @Override
    public void updateBeerFields(String name, String description, String itemCode, String origin, String volume,
                                 String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
                                 String bottleWeight, String caseWeight, String quantity, String isExclusive,
                                 String isDualState, String caseSize, String lotDate, String expirationDate,
                                 String beerType, String brewery, String isDomestic, String isSeasonal, String beerID,
                                 String id) {

    }

    @Override
    public void updateLiquorFields(String name, String description, String itemCode, String origin, String volume,
                                   String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
                                   String bottleWeight, String caseWeight, String quantity, String isExclusive,
                                   String isDualState, String caseSize, String liquorType, String distillery,
                                   String liquorID, String id) {

    }
}