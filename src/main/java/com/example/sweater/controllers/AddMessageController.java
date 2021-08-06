package com.example.sweater.controllers;

import com.example.sweater.domain.Message;
import com.example.sweater.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AddMessageController {
    @Autowired
    private MessageRepository messageRepository;
    @PostMapping("/main")
    public String add(@RequestParam String text, @RequestParam String tag,
                      Map<String, Object> model) {
        Message message = new Message(text, tag);

        messageRepository.save(message);
        Iterable<Message> messages = messageRepository.findAll();
        model.put("messages", messages);
        return "main";
    }
}