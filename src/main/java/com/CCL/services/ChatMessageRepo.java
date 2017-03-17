package com.CCL.services;

import com.CCL.entities.messages.ChatMessage;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mike on 3/16/2017.
 */
public interface ChatMessageRepo extends CrudRepository<ChatMessage, Integer> {
}
