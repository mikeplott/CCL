package com.CCL.services;

import com.CCL.entities.employees.Driver;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface DriverRepo extends CrudRepository<Driver, Integer> {
}
