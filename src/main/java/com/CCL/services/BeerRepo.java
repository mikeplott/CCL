package com.CCL.services;

import com.CCL.entities.products.Beer;
import com.CCL.entities.products.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface BeerRepo extends CrudRepository<Beer, Integer> {
    Beer findByName(String name);
    Beer findByItemCode(String itemCode);
    ArrayList findAllByNameLikeIgnoreCase(String name);
    ArrayList findAllByItemCodeLikeIgnoreCase(String itemCode);
    ArrayList findAllByBreweryLikeIgnoreCase(String brewery);

    @Modifying
    @Transactional
    @Query("update Beer w set w.name = ?1, w.description = ?2,  w.itemCode = ?3, w.origin = ?4," +
            "w.volume = ?5, w.frontPrice = ?6, w.tenCasePrice = ?7, w.twentyFiveCasePrice = ?8, w.cost = ?9," +
            "w.bottleWeight = ?10, w.caseWeight = ?11, w.quantity = ?12, w.isExclusive = ?13, w.isDualState = ?14," +
            "w.caseSize = ?15, w.lotDate = ?16, w.expirationDate = ?17, w.beerType = ?18, w.brewery = ?19," +
            "w.isDomestic = ?20, w.isSeasonal = ?21  where w.id = ?22")
    void setBeerInfo(String name, String description, String itemCode, String origin, String volume,
                                double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost,
                                double bottleWeight, double caseWeight, double quantity, boolean isExclusive,
                                boolean isDualState, Beer.caseSize caseSize, Date lotDate, Date expirationDate,
                                String beerType, String brewery, boolean isDomestic, boolean isSeasonal, int id);
}
