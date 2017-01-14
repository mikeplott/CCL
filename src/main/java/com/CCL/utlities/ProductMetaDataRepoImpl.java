package com.CCL.utlities;

import com.CCL.services.ProductMetaDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;

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
}

//    void ProductMetaWDataWineInfo(String name, String description, String itemCode, String origin, String volume,
//                                  String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
//                                  String bottleWeight, String caseWeight, String quantity, String isExclusive,
//                                  String isDualState, String caseSize, String vintage, String varietal, String color,
//                                  String importer, String wineID, String id);
//
//    }
//
//    @Modifying
//    @Query(nativeQuery = true)
//    public void updateBeerFields(String name, String description, String itemCode, String origin, String volume,
//                                 String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
//                                 String bottleWeight, String caseWeight, String quantity, String isExclusive,
//                                 String isDualState, String caseSize, String lotDate, String expirationDate,
//                                 String beerType, String brewery, String isDomestic, String isSeasonal, String beerID,
//                                 String id) {
//        ("update ProductMetaData w set w.name = ?1, w.description = ?2,  w.itemCode = ?3, w.origin = ?4," +
//                "w.volume = ?5, w.frontPrice = ?6, w.tenCasePrice = ?7, w.twentyFiveCasePrice = ?8, w.cost = ?9," +
//                "w.bottleWeight = ?10, w.caseWeight = ?11, w.quantity = ?12, w.isExclusive = ?13, w.isDualState = ?14," +
//                "w.caseSize = ?15, w.lotDate = ?16, w.expirationDate = ?17, w.beerType = ?18, w.brewery = ?19, " +
//                "w.isDomestic = ?20, w.isSeasonal = ?21, w.beerID = ?22 where w.id = ?23")
//        void ProductMetaDataBeerInfo(String name, String description, String itemCode, String origin, String volume,
//                String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
//                String bottleWeight, String caseWeight, String quantity, String isExclusive,
//                String isDualState, String caseSize, String lotDate, String expirationDate,
//                String beerType, String brewery, String isDomestic, String isSeasonal, String beerID,
//                String id);
//    }
//
//    @Modifying
//    @Query(nativeQuery = true)
//    public void updateLiquorFields(String name, String description, String itemCode, String origin, String volume,
//                                   String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
//                                   String bottleWeight, String caseWeight, String quantity, String isExclusive,
//                                   String isDualState, String caseSize, String liquorType, String distillery,
//                                   String liquorID, String id) {
//
//        ("update ProductMetaData w set w.name = ?1, w.description = ?2,  w.itemCode = ?3, w.origin = ?4," +
//                "w.volume = ?5, w.frontPrice = ?6, w.tenCasePrice = ?7, w.twentyFiveCasePrice = ?8, w.cost = ?9," +
//                "w.bottleWeight = ?10, w.caseWeight = ?11, w.quantity = ?12, w.isExclusive = ?13, w.isDualState = ?14," +
//                "w.caseSize = ?15, w.liquorType = ?16, w.distillery = ?17, w.liquorID = ?18 where w.id = ?19");
//
//        void ProductMetaDataLiquorInfo(String name, String description, String itemCode, String origin, String volume,
//                String frontPrice, String tenCasePrice, String twentyFiveCasePrice, String cost,
//                String bottleWeight, String caseWeight, String quantity, String isExclusive,
//                String isDualState, String caseSize, String liquorType, String distillery,
//                String liquorID, String id)
//
//    }







