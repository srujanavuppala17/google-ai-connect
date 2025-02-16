package genai;


import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.generativeai.preview.GenerativeModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;


@Configuration
class GenerativeAIConfig {
    @Value("${google.cloud.project-id}")
    private String projectId;
    @Value("${google.cloud.access-token}")
    private  String ACCESS_TOKEN ;

    @Bean
    public VertexAI vertexAI() throws IOException {
        GoogleCredentials credentials = GoogleCredentials.create(
                new AccessToken(ACCESS_TOKEN, new Date(System.currentTimeMillis() + 3600 * 1000)) // Token expires in 1 hour
        ).createScoped(Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));

        return new VertexAI(projectId, "us-central1", credentials);
    }


    @Bean    public GenerativeModel generativeModel(VertexAI vertexAI) {
        return new GenerativeModel("gemini-pro", vertexAI);
    }

}
