package com.CCL.services;

import com.CCL.entities.messages.DirectMessage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mike on 3/16/2017.
 */
public interface DirectMessageRepo extends CrudRepository<DirectMessage, Integer> {
}
