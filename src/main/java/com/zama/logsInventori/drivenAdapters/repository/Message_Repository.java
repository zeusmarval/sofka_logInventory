package com.zama.logsInventori.drivenAdapters.repository;

import com.zama.logsInventori.Models.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.Optional;

@Repository
public interface Message_Repository extends ReactiveMongoRepository<Message, String> {

    Flux<Message> findByAction(String action);

    @Aggregation("{ $match: { 'product.name': ?0 } }")
    Flux<Message> findSalesDetailByProductName(String productName);

}
