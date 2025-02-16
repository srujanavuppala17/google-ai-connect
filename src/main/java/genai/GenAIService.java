package genai;


import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.preview.GenerativeModel;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GenAIService {

    private final GenerativeModel generativeModel;

    GenAIService(GenerativeModel generativeModel) {
        this.generativeModel = generativeModel;
    }
    public String generateTextWithVertexAI(String prompt) throws IOException {
        GenerateContentResponse response = generativeModel.generateContent(prompt);
        return response.getCandidates(0).getContent().getParts(0).getText();
    }


}
