package com.CCL.services;

import com.CCL.entities.products.ProductMetaData;
import com.CCL.utlities.ProductMetaDataRepoCustom;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;

/**
 * Created by michaelplott on 1/13/17.
 */

public interface ProductMetaDataRepo extends MongoRepository<ProductMetaData, String>, ProductMetaDataRepoCustom {
    ArrayList<ProductMetaData> findAllByNameContainingIgnoreCase(String name);

    ArrayList<ProductMetaData> findByItemCodeContainingIgnoreCase(String itemCode);

    ArrayList<ProductMetaData> findByBreweryContainingIgnoreCase(String brewery);

    ArrayList<ProductMetaData> findByDistilleryContainingIgnoreCase(String distillery);

    ArrayList<ProductMetaData> findByImporterContainingIgnoreCase(String importer);
}