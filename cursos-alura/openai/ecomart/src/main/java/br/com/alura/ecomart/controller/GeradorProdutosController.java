package br.com.alura.ecomart.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor Jairo Nascimento
 * @Created 01/04/2026 - 14:26
 */
@RestController
@RequestMapping("gerador")
public class GeradorProdutosController {

    private final ChatClient chatClient;

    public GeradorProdutosController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }


    @GetMapping
    public String gerarProdutos() {
        var pergunta = "Gere 3 produtos ecologicos";
        return this.chatClient.prompt()
                .user(pergunta)
                .call()
                .content();
    }
}
