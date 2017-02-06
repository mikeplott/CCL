package com.CCL.services;

import com.CCL.entities.fleet.Vehicle;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 2/6/17.
 */
public interface FleetRepo extends CrudRepository<Vehicle, Integer> {
}
