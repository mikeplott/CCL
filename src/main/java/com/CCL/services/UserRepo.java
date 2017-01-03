package com.CCL.services;

import com.CCL.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

/**
 * Created by michaelplott on 1/3/17.
 */
public interface UserRepo extends CrudRepository<User, Integer> {
    ArrayList<User> findAll();
    User findByUserName(String userName);
}
