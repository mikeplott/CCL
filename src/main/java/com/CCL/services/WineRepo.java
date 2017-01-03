package com.CCL.services;

import com.CCL.entities.products.Wine;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface WineRepo extends CrudRepository<Wine, Integer> {
}
