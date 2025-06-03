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
    /**
     * Generates text for the supplied prompt using Vertex AI.
     * <p>
     * If Vertex AI does not return any candidates this method returns an empty
     * string.
     *
     * @param prompt text prompt to send to Vertex AI
     * @return generated text or an empty string when no candidates are returned
     * @throws IOException if an error occurs communicating with Vertex AI
     */
    public String generateTextWithVertexAI(String prompt) throws IOException {
        GenerateContentResponse response = generativeModel.generateContent(prompt);
        if (response.getCandidatesCount() == 0) {
            return "";
        }
        return response.getCandidates(0).getContent().getParts(0).getText();
    }


}
