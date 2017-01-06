package com.CCL.services;

import com.CCL.entities.products.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 1/5/17.
 */
public interface ProductRepo extends CrudRepository<Product, Integer> {
    Product findByItemCode(String itemCode);
    Product findByName(String itemName);
    Product findByImporter(String importer);
    Product findByBrewery(String importer);
    Product findByDistillery(String distillery);
}
