package no.training.project.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import no.training.project.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/martian-weather")
public class NasaMapper {
    private static final String MARS_NASA_URL = "https://mars.nasa.gov/rss/api/?feed=weather&feedtype=json&ver=1.0&category=msl";
    private static final Logger LOG = LoggerFactory.getLogger(NasaMapper.class);

    @GET
    @Path("/")
    public String getMartianWeather() throws IOException, InterruptedException
    {
        try {
            HttpClient client = HttpClient.newHttpClient();// send requests and retrieve their responses.
            LOG.debug("Generated HTTP client connection");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(MARS_NASA_URL))
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());//convert the response body bytes into a String

            System.out.println(response.body());
            System.out.println(response.uri());
            System.out.println(response.statusCode());
            ObjectMapper objectMapper = new ObjectMapper();
            Response resp = objectMapper.readValue(response.body(), Response.class);
            System.out.println(resp.toString());
            System.out.println("Response in file:" + response.body());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error:", e);

        }

    }
}

























