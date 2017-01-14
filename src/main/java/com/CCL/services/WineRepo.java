package com.CCL.services;

import com.CCL.entities.products.Product;
import com.CCL.entities.products.Wine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface WineRepo extends CrudRepository<Wine, Integer> {
    ArrayList<Wine> findAll();
    Wine findByItemCode(String itemCode);
    Wine findByName(String name);
    ArrayList findAllByNameContaining(String name);
    ArrayList findAllByNameLikeIgnoreCase(String name);
    ArrayList findAllByItemCodeLikeIgnoreCase(String itemCode);
    ArrayList findAllByImporterLikeIgnoreCase(String importer);

    @Modifying
    @Transactional
    @Query("update Wine w set w.name = ?1, w.description = ?2,  w.itemCode = ?3, w.origin = ?4, w.volume = ?5," +
            "w.frontPrice = ?6, w.tenCasePrice = ?7, w.twentyFiveCasePrice = ?8, w.cost = ?9, w.bottleWeight = ?10, " +
            "w.caseWeight = ?11, w.quantity = ?12, w.isExclusive = ?13, w.isDualState = ?14, w.caseSize = ?15, w" +
            ".vintage = ?16, w.varietal = ?17,w.color = ?18, w.importer = ?19 where w.id = ?20")
    void setWineInfo(String name, String description, String itemCode, String origin, String volume, double
            frontPrice, double tenCasePrice, double twentyFiveCasePrice, double cost, double bottleWeight, double
            caseWeight, int quantity, boolean isExclusive, boolean isDualState, Product.caseSize caseSize, int vintage, String varietal, String
            color, String importer, int id);
}
