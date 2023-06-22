import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;



//import Constants;

@SpringBootApplication
@RestController
public class Devopsapp {
    
    public static final String API_KEY = "your-api-key";

    public static void main(String[] args) {
        SpringApplication.run(Devopsapp.class, args);
    }

    //@GetMapping("/")
    @RequestMapping("/")
    public String home() {
        return "Microservice is running";
    }

    @PostMapping("/Devops")
    public String handleDevops(@RequestBody String requestBody, @RequestHeader("X-Parse-REST-API-Key") String apiKey) {
        if (!API_KEY.equals(apiKey)) {
            return "Invalid API key";
        }

        // Parse the JSON request body
        // Assuming the request body contains {"to": "recipient"}
        // You can use a JSON library like Jackson or Gson for parsing
        // Here's a simple example using Jackson ObjectMapper
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(requestBody);
            String recipient = jsonNode.get("to").asText();
            String message = "Hello " + recipient + ", your message will be sent";

            // Create a JSON response
            ObjectNode response = objectMapper.createObjectNode();
            response.put("message", message);

            // Convert the response to a JSON string
            return objectMapper.writeValueAsString(response);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error parsing request body";
        }
    }
}
