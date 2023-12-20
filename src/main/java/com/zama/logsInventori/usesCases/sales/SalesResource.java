package com.zama.logsInventori.usesCases.sales;

import com.zama.logsInventori.Models.Message;
import com.zama.logsInventori.drivenAdapters.repository.Message_Repository;
import com.zama.logsInventori.utils.Mappers.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class SalesResource {
    @Autowired
    private Message_Repository messageRepository;

    public Flux<Message> getSalesForType(String typeSale) {
        return messageRepository.findSalesDetailByType(typeSale)
                .map(MessageMapper::toEntity);
    }
}
