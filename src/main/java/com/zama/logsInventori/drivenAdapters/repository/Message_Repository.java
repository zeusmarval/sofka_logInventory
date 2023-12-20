package com.zama.logsInventori.drivenAdapters.repository;

import com.zama.logsInventori.Models.Message;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface Message_Repository extends ReactiveMongoRepository<Message, String> {
    Flux<Message> findByAction(String action);
}
