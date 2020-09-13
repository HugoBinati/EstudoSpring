package org.example.controllers;


import org.example.domain.Message;
import org.example.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "messages")
public class MessageController {

    @Autowired
    private MessageService service;

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody String message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(message));
    }

    @GetMapping
    public ResponseEntity<List<Message>> findAll(){
       return ResponseEntity.status(HttpStatus.OK).body(service.listMessages());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Message> findOne(@PathVariable("id") Integer messageId){
        return ResponseEntity.status(HttpStatus.OK).body(service.findMessage(messageId));
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer messageId){
        service.deleteMessage(messageId);
        return ResponseEntity.status(HttpStatus.OK).body("A mensagem de id: " + messageId.toString() + " foi deletada com sucesso");
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Message> update(@PathVariable("id") Integer messageID, @RequestBody String message){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateMessage(messageID, message));
    }

}
