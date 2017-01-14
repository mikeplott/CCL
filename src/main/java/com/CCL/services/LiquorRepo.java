package com.CCL.services;

import com.CCL.entities.products.Beer;
import com.CCL.entities.products.Liquor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface LiquorRepo extends CrudRepository<Liquor, Integer> {
    Liquor findByName(String name);
    Liquor findByItemCode(String itemCode);
    ArrayList findAllByNameContaining(String name);
    ArrayList findAllByNameLikeIgnoreCase(String name);
    ArrayList findAllByItemCodeLikeIgnoreCase(String itemCode);
    ArrayList findAllByDistilleryLikeIgnoreCase(String distillery);

    @Modifying
    @Transactional
    @Query("update Liquor w set w.name = ?1, w.description = ?2, w.itemCode = ?3, w.origin = ?4, " +
            "w.volume = ?5, w.frontPrice = ?6, w.tenCasePrice = ?7, w.twentyFiveCasePrice = ?8, w.cost = ?9, " +
            "w.bottleWeight = ?10, w.caseWeight = ?11, w.quantity = ?12, w.isExclusive = ?13, w.isDualState = ?14, " +
            "w.caseSize = ?15, w.liquorType = ?16, w.distillery = ?17 where w.id = ?18")
    void setLiquorInfo(String name, String description, String itemCode, String origin, String volume,
                         double frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost,
                         double bottleWeight, double caseWeight, double quantity, boolean isExclusive,
                         boolean isDualState, Beer.caseSize caseSize, String liquorType, String distillery, int id);
}
