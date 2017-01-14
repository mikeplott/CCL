package com.CCL.services;

import com.CCL.entities.products.Beer;
import com.CCL.entities.products.Liquor;
import com.CCL.utlities.LiquorRepoCustom;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface LiquorRepo extends CrudRepository<Liquor, Integer>, LiquorRepoCustom {
    Liquor findByName(String name);
    Liquor findByItemCode(String itemCode);
    ArrayList findAllByNameContaining(String name);
    ArrayList findAllByNameLikeIgnoreCase(String name);
    ArrayList findAllByItemCodeLikeIgnoreCase(String itemCode);
    ArrayList findAllByDistilleryLikeIgnoreCase(String distillery);
}
