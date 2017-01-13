package com.CCL.services;

import com.CCL.entities.employees.EmpMetaData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Mike on 1/12/2017.
 */
public interface EmpMetaDataRepo extends MongoRepository<EmpMetaData, String> {
}
