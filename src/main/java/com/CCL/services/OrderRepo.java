package com.CCL.services;

import com.CCL.entities.accounts.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface OrderRepo extends CrudRepository<Order, Integer> {
}
