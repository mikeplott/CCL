package com.CCL.services;

import com.CCL.entities.employees.SalesRep;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface SalesRepRepo extends CrudRepository<SalesRep, Integer> {
}
