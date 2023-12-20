package com.zama.logsInventori.usesCases.erros;

import com.zama.logsInventori.Models.Message;
import com.zama.logsInventori.drivenAdapters.repository.Message_Repository;
import com.zama.logsInventori.utils.Mappers.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class ErrorResource {

    @Autowired
    private Message_Repository messageRepository;

    public Flux<Message> getErros() {

        return messageRepository.findByAction("Error").map(MessageMapper::toEntity);
    }

}
