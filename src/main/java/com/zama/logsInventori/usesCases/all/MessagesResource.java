package com.zama.logsInventori.usesCases.all;

import com.zama.logsInventori.Models.Message;
import com.zama.logsInventori.drivenAdapters.repository.Message_Repository;
import com.zama.logsInventori.utils.Mappers.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class MessagesResource {

    @Autowired
    private Message_Repository messageRepository;

    public Flux<Message> getAllMessagesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return messageRepository.findAll(pageable.getSort())
                .map(MessageMapper::toEntity);
    }


}
