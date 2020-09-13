package org.example.services;

import org.example.domain.Message;
import org.example.repositories.MessageRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repo;

    public Message save(String text) {
        return repo.save(new Message(text));
    }

    public List<Message> listMessages() {
        return repo.findAll();
    }

    public Message findMessage(Integer Id) {
        return repo.findById(Id).orElseThrow(() -> new ObjectNotFoundException("Não foi encontrado uma messagem com o id: " + Id, null));
    }

    public void deleteMessage(Integer messageId) {
        repo.deleteById(messageId);
    }

    public Message updateMessage(Integer messageID, String newMessage) {
        Message message = findMessage(messageID);
        message.setText(newMessage);
        return repo.save(message);
    }
}
