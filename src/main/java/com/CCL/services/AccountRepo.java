package com.CCL.services;

import com.CCL.entities.accounts.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface AccountRepo extends CrudRepository<Account, Integer> {
}
