package br.com.alura.ecomart.controller;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.Encoding;
import com.knuddels.jtokkit.api.EncodingRegistry;
import com.knuddels.jtokkit.api.ModelType;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autor Jairo Nascimento
 * @Created 01/04/2026 - 14:26
 */
@RestController
@RequestMapping("categorizador")
public class CategprizadorDeProdutosController {

    private final ChatClient chatClient;

    public CategprizadorDeProdutosController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultOptions(ChatOptions.builder()
//                        .model("gpt-4o-mini")
                        .build()).build();
    }

    @GetMapping
    public String categorizar(String produto) {
//        var system = "Você é um categorizador de produtos e deve responder apenas o nome da categoria do produto informado";

        var system = """
                Você é um categorizador de produtos e deve responder apenas o nome da categoria do produto informado
                
                Escolha uma categoria dentra a lista abaixo:
                
                1. Higiene pessoal
                2. Eletronicos
                3. Esportes
                4. Outros
                
                ###### exemplo de uso:
                
                Pergunta: Bola de futebol
                Resposta: Esportes
                """;

        var tokens = contarToken(system, produto);

        System.out.println("Tokens===> " + tokens);

        return this.chatClient.prompt()
                .system(system)
                .user(produto)
                .options(ChatOptions.builder()
                        .temperature(0.85)
                        .model("gpt-4o-mini")
                        .build())
                .advisors(new SimpleLoggerAdvisor())
                .call()
                .content();
    }

    private int contarToken(String system, String user) {
        EncodingRegistry registry = Encodings.newDefaultEncodingRegistry();
        Encoding enc = registry.getEncodingForModel(ModelType.GPT_4O_MINI);

        return enc.countTokens(system + user);
    }
}
