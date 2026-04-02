package br.com.alura.ecomart.controller;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor Jairo Nascimento
 * @Created 01/04/2026 - 14:26
 */
@RestController
@RequestMapping("imagem")
public class GeradorDeImagemController {

    private final ImageModel imageModel;

    public GeradorDeImagemController(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    @GetMapping
    public String gerarImagem(String prompt) {
        var options = ImageOptionsBuilder.builder()
                .height(1024)
                .width(1024)
                .build();
        var reponse = imageModel.call(new ImagePrompt(prompt, options));

        return reponse.getResult().getOutput().getUrl();

    }
}
