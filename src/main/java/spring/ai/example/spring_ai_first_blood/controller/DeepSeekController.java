package spring.ai.example.spring_ai_first_blood.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import spring.ai.example.spring_ai_first_blood.service.DeepSeekService;

@RestController
@RequestMapping("/deepseek")
public class DeepSeekController {

    private final DeepSeekService deepSeekService;

    public DeepSeekController(DeepSeekService deepSeekService) {
        this.deepSeekService = deepSeekService;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        return deepSeekService.chat(message);
    }

    @GetMapping(value = "/stream", produces = "text/event-stream")
    public Flux<String> chatWithStream(@RequestParam String message) {
        return deepSeekService.chatWithStream(message);
    }

}
