package no.training.project.resource.martianweather;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import no.training.project.Mapper.NasaMapper;
import no.training.project.exception.ServiceException;
import no.training.project.model.ExternalResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/martian-weather")
public class MartianWeather {
    private static final String MARS_NASA_URL = "https://mars.nasa.gov/rss/api/?feed=weather&feedtype=json&ver=1.0&category=msl";
    private static final Logger LOG = LoggerFactory.getLogger(MartianWeather.class);

    private HttpClient httpClient;

    public MartianWeather(HttpClient httpClient) {
        this.httpClient = httpClient;
    }
    public MartianWeather(){
        this.httpClient = HttpClient.newHttpClient();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public ExternalResponse getMartianWeather() throws IOException, InterruptedException {
        try {

            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(MARS_NASA_URL)).method("GET", HttpRequest.BodyPublishers.noBody()).build();// send requests and retrieve their responses.
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());//convert the response body bytes into a String
            if(response.statusCode()==200){
                NasaMapper nasaMapper = new NasaMapper();
                ExternalResponse externalResponse = nasaMapper.getNasaObject(response);
                LOG.info("Returns the external response {}", externalResponse);
                return externalResponse;
            }
            else {
               throw new ServiceException("Internal error found", response.statusCode());
            }
        } catch (Exception e) {
           throw e;
        }
    }
}
