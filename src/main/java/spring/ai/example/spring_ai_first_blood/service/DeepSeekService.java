package spring.ai.example.spring_ai_first_blood.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class DeepSeekService {

    private final ChatClient chatClient;

    public DeepSeekService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String chat(String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .call()
                .content();
    }

    public Flux<String> chatWithStream(String prompt) {
        return chatClient.prompt()
                .user(prompt)
                .stream()
                .content();
    }
}
