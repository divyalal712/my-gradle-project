package no.training.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.training.project.exception.ServiceException;
import no.training.project.model.Description;
import no.training.project.model.ExternalResponse;
import no.training.project.model.Sole;
import no.training.project.resource.martianweather.MartianWeather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MartianWeatherTest {
    private HttpResponse<Object> Exception;

    @Mock
    private HttpClient defaultHttpClient;
    private MartianWeather date;

    @Test
    public void getMartianWeatherSuccessTest() throws IOException, InterruptedException {

        HttpClient httpClient = mock(HttpClient.class);
        HttpResponse response = mock(HttpResponse.class);

        when(response.statusCode()).thenReturn(200);

        ObjectMapper objectMapper = new ObjectMapper();
        ExternalResponse externalRep = getExternalResponse();
        String externalResponseString = objectMapper.writeValueAsString(externalRep);
        when(response.body()).thenReturn(externalResponseString);


        MartianWeather martian = new MartianWeather(httpClient);

        when(httpClient.send(any(), any())).thenReturn(response);
        ExternalResponse martianWeather = martian.getMartianWeather();
        Assertions.assertNotNull(martianWeather);
    }

    private static ExternalResponse getExternalResponse() throws IOException {
        String response = new String(MartianWeatherTest.class.getResourceAsStream("/mock-data/success-response.json").readAllBytes());
        ExternalResponse responseAsObject = new ObjectMapper().readValue(response, ExternalResponse.class);
        return responseAsObject;
    }
    @Test
    public void getMartianWeatherNotFoundTest() throws IOException, InterruptedException {
        try {

            HttpClient httpClient = mock(HttpClient.class);
            HttpResponse response = mock(HttpResponse.class);

            when(response.statusCode()).thenReturn(404);
            MartianWeather martian = new MartianWeather(httpClient);

            when(httpClient.send(any(), any())).thenReturn(response);
            martian.getMartianWeather();
        } catch (ServiceException exception) {
            Assertions.assertEquals("Internal error found", exception.getErrorMessage());
            Assertions.assertEquals(404, exception.getStatusCode());
        }
    }

    @Test
    public void getInternalServerError() throws IOException, InterruptedException {
        try {

            HttpClient httpClient = mock(HttpClient.class);
            HttpResponse response = mock(HttpResponse.class);

            when(response.statusCode()).thenReturn(500);
            MartianWeather martian = new MartianWeather(httpClient);

            when(httpClient.send(any(), any())).thenReturn(response);
            martian.getMartianWeather();
        } catch (ServiceException exception) {
            Assertions.assertEquals("Internal error found", exception.getErrorMessage());
            Assertions.assertEquals(500, exception.getStatusCode());
        }
    }

    @Test
    public void getHandleException() throws IOException, InterruptedException {
        try {

            HttpClient httpClient = mock(HttpClient.class);
            HttpResponse response = mock(HttpResponse.class);
            MartianWeather martian = new MartianWeather(httpClient);

            when(httpClient.send(any(), any())).thenThrow(new RuntimeException("Found Runtime Exception"));
            martian.getMartianWeather();
        } catch (RuntimeException exception) {
            Assertions.assertEquals("Found Runtime Exception", exception.getMessage());
        }
    }

    @Test
    public void soleBasedOnDateTest() throws IOException, InterruptedException {
        HttpClient httpClient = mock(HttpClient.class);
        HttpResponse response = mock(HttpResponse.class);
        when(httpClient.send(any(), any())).thenReturn(response);
        when(response.statusCode()).thenReturn(200);
        ObjectMapper objectMapper = new ObjectMapper();
        ExternalResponse externalRep = getExternalResponse();
        String externalResponseString = objectMapper.writeValueAsString(externalRep);
        when(response.body()).thenReturn(externalResponseString);
        MartianWeather martian = new MartianWeather();
        Sole sole = martian.soleBasedOnDate("2022-06-27");
        Assertions.assertNotNull(sole);
        Assertions.assertEquals(sole.terrestrialDate(),"2022-06-27");
        //Assertions.assertEquals(sole.getTerrestrial_date(), "2022-06-27");
    }

    @Test
    public void wrongDateFormat() throws IOException, InterruptedException {

        try {
            MartianWeather martian = new MartianWeather();
            Sole sole = martian.soleBasedOnDate("09-06-2022");
        } catch (RuntimeException exception) {
            Assertions.assertEquals("Date given is not in proper format", exception.getMessage());
        }
    }
}