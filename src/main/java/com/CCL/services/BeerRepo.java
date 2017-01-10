package com.CCL.services;

import com.CCL.entities.products.Beer;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface BeerRepo extends CrudRepository<Beer, Integer> {
    Beer findByItemCode(String itemCode);
    ArrayList findAllByNameContaining(String name);
}
