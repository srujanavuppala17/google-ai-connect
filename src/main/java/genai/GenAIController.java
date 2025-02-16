package genai;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class GenAIController {

    private GenAIService geminiService;


    public GenAIController(GenAIService geminiService) {
        this.geminiService = geminiService;
    }

    // Call using Vertex AI SDK
    @GetMapping("/vertex-ai")
    public String chatWithVertexAI(@RequestParam String prompt) throws IOException {
        return geminiService.generateTextWithVertexAI(prompt);
    }

}
