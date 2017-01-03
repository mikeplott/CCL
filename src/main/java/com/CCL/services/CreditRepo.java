package com.CCL.services;

import com.CCL.entities.accounts.Credit;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface CreditRepo extends CrudRepository<Credit, Integer> {
}
