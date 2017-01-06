package com.CCL.services;

import com.CCL.entities.products.Wine;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface WineRepo extends CrudRepository<Wine, Integer> {
    ArrayList<Wine> findAll();
    Wine findByItemCode(String itemCode);
}
