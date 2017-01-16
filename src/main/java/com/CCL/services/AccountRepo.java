package com.CCL.services;

import com.CCL.entities.accounts.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface AccountRepo extends CrudRepository<Account, Integer> {
    ArrayList<Account> findAllByNameContainingIgnoreCase(String name);
    Account findByNameContainingIgnoreCase(String name);
    Account findByAccountNumber(String accountNumber);
}
