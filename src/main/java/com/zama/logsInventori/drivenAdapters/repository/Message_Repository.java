package com.zama.logsInventori.drivenAdapters.repository;

import com.zama.logsInventori.Models.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface Message_Repository extends ReactiveMongoRepository<Message, String> {
}
