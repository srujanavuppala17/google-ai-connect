package genai;

import com.google.cloud.vertexai.api.Candidate;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.api.Part;
import com.google.cloud.vertexai.generativeai.preview.GenerativeModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GenAIServiceTest {

    @Mock
    private GenerativeModel generativeModel;
    @Mock
    private GenerateContentResponse response;
    @Mock
    private Candidate candidate;
    @Mock
    private Content content;
    @Mock
    private Part part;

    private GenAIService service;

    @BeforeEach
    void setUp() {
        service = new GenAIService(generativeModel);
    }

    @Test
    void generateTextWithVertexAI_returnsCandidateText() throws IOException {
        when(generativeModel.generateContent("prompt")).thenReturn(response);
        when(response.getCandidatesCount()).thenReturn(1);
        when(response.getCandidates(0)).thenReturn(candidate);
        when(candidate.getContent()).thenReturn(content);
        when(content.getParts(0)).thenReturn(part);
        when(part.getText()).thenReturn("expected text");

        String result = service.generateTextWithVertexAI("prompt");
        assertEquals("expected text", result);
    }

    @Test
    void generateTextWithVertexAI_emptyCandidatesReturnsEmptyString() throws IOException {
        when(generativeModel.generateContent(anyString())).thenReturn(response);
        when(response.getCandidatesCount()).thenReturn(0);

        String result = service.generateTextWithVertexAI("prompt");
        assertEquals("", result);
        verify(response, never()).getCandidates(anyInt());
    }
}

