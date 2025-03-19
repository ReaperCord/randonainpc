package com.randonainpc.controller;

import com.randonainpc.service.ChatGptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@org.springframework.web.bind.annotation.RestController
public class AventuraController {

    private ChatGptService chatGptService;

    public AventuraController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @GetMapping
    public Mono<ResponseEntity<String>> gerarAventura() {
        return chatGptService.gerarAventura();

    }




}