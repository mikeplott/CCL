package com.CCL.services;

import com.CCL.entities.products.Beer;
import com.CCL.entities.products.Product;
import com.CCL.utlities.BeerRepoCustom;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface BeerRepo extends CrudRepository<Beer, Integer>, BeerRepoCustom {
    Beer findByName(String name);
    Beer findByItemCode(String itemCode);
    ArrayList findAllByNameLikeIgnoreCase(String name);
    ArrayList findAllByItemCodeLikeIgnoreCase(String itemCode);
    ArrayList findAllByBreweryLikeIgnoreCase(String brewery);
}
