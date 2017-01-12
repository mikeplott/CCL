package com.CCL.services;

import com.CCL.entities.products.Liquor;
import org.springframework.data.repository.CrudRepository;

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
}
