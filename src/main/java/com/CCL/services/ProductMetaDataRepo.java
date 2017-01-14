package com.CCL.services;

import com.CCL.entities.products.ProductMetaData;
import com.CCL.utlities.ProductMetaDataRepoCustom;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;

/**
 * Created by michaelplott on 1/13/17.
 */

public interface ProductMetaDataRepo extends MongoRepository<ProductMetaData, String>, ProductMetaDataRepoCustom {
    ArrayList findAllByNameContainingIgnoreCase(String name);

    ArrayList findByItemCodeContainingIgnoreCase(String itemCode);

    ArrayList findByBreweryContainingIgnoreCase(String brewery);

    ArrayList findByDistilleryContainingIgnoreCase(String distillery);

    ArrayList findByImporterContainingIgnoreCase(String importer);
}