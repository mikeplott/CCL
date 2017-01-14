package com.CCL.services;

import com.CCL.entities.products.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by michaelplott on 1/5/17.
 */
public interface ProductRepo extends CrudRepository<Product, Integer> {

}
