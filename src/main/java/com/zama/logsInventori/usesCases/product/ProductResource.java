package com.zama.logsInventori.usesCases.product;

import com.zama.logsInventori.Models.Message;
import com.zama.logsInventori.drivenAdapters.repository.Message_Repository;
import com.zama.logsInventori.utils.Mappers.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ProductResource {
    @Autowired
    private Message_Repository messageRepository;

    public Flux<Message> getMovementsProduct(String name) {

        return messageRepository.findSalesDetailByProductName(name)
                .map(MessageMapper::toEntity);
    }

}
