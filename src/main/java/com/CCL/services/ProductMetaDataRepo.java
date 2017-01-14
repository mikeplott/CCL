package com.CCL.services;

import com.CCL.entities.products.Product;
import com.CCL.entities.products.ProductMetaData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * Created by michaelplott on 1/13/17.
 */
public interface ProductMetaDataRepo extends MongoRepository<ProductMetaData, String> {
    ArrayList findAllByNameContainingIgnoreCase(String name);
    ArrayList findByItemCodeContainingIgnoreCase(String itemCode);
    ArrayList findByBreweryContainingIgnoreCase(String brewery);
    ArrayList findByDistilleryContainingIgnoreCase(String distillery);
    ArrayList findByImporterContainingIgnoreCase(String importer);

}
