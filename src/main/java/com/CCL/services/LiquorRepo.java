package com.CCL.services;

import com.CCL.entities.products.Liquor;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface LiquorRepo extends CrudRepository<Liquor, Integer> {
}
