package com.CCL.services;

import com.CCL.entities.products.Product;
import com.CCL.entities.products.Wine;
import com.CCL.utlities.WineRepoCustom;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface WineRepo extends CrudRepository<Wine, Integer>, WineRepoCustom {
    ArrayList<Wine> findAll();
    Wine findByItemCode(String itemCode);
    Wine findByName(String name);
    ArrayList findAllByNameContaining(String name);
    ArrayList findAllByNameLikeIgnoreCase(String name);
    ArrayList findAllByItemCodeLikeIgnoreCase(String itemCode);
    ArrayList findAllByImporterLikeIgnoreCase(String importer);
}
