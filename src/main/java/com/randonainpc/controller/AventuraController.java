package com.randonainpc.controller;

import com.randonainpc.service.ChatGptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import static org.apache.commons.lang3.StringUtils.defaultIfEmpty;

@org.springframework.web.bind.annotation.RestController
public class AventuraController {

    private ChatGptService chatGptService;

    public AventuraController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    @GetMapping("/generate")
    public Mono<ResponseEntity<String>> gerarAventura() {
        return chatGptService.gerarAventura()
                .map(aventura -> ResponseEntity.ok(aventura))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }




}