package no.training.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.training.project.exception.ServiceException;
import no.training.project.model.ExternalResponse;
import no.training.project.model.Release;
import no.training.project.resource.martianweather.MartianWeather;
import no.training.project.resource.version.Version;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mock;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

public class VersionTest {
    private HttpResponse<Object> Exception;

    @Mock
    private HttpClient defaultHttpClient;
    private static Release getRelease() throws IOException {
        String response = new String(VersionTest.class.getResourceAsStream("/mock-data/release-response.json").readAllBytes());
        Release responseAsObject = new ObjectMapper().readValue(response, Release.class);
        return responseAsObject;
    }

    @Test
    public void successTest() throws IOException, InterruptedException, ServiceException {
        HttpClient httpClient = mock(HttpClient.class);
        HttpResponse response = mock(HttpResponse.class);
        when(response.statusCode()).thenReturn(200);

        ObjectMapper objectMapper = new ObjectMapper();
        Release release = getRelease();
        String externalResponseString = objectMapper.writeValueAsString(release);
        when(response.body()).thenReturn(externalResponseString);
        Version version = new Version(httpClient);
        when(httpClient.send(any(), any())).thenReturn(response);
        Release release1 = version.getReleaseVersion("arm");
        Assertions.assertNotNull(release1);

    }

    @Test
    public void releaseNotFoundTest() throws ServiceException, IOException, InterruptedException {
        try {
            HttpClient httpClient = mock(HttpClient.class);
            HttpResponse response = mock(HttpResponse.class);
            when(response.statusCode()).thenReturn(404);
            Version version = new Version(httpClient);
            when(httpClient.send(any(), any())).thenReturn(response);
            version.getReleaseVersion("");
        } catch (ServiceException exception) {
            Assertions.assertEquals("Internal error found", exception.getErrorMessage());
            Assertions.assertEquals(404, exception.getStatusCode());
        }
    }

    @Test
    public void getInternalErrorTest() throws IOException, InterruptedException {
        try {
            HttpClient httpCLient = mock(HttpClient.class);
            HttpResponse response = mock(HttpResponse.class);
            when(response.statusCode()).thenReturn(500);
            Version version = new Version(httpCLient);
            when(httpCLient.send(any(), any())).thenReturn(response);
            version.getReleaseVersion("");
        }
        catch(ServiceException exception){
            Assertions.assertEquals("Internal error found",exception.getErrorMessage());
            Assertions.assertEquals(500,exception.getStatusCode());
        }
    }

    @Test
    public void getHandleException() throws IOException, InterruptedException, ServiceException {
        try {
            HttpClient httpClient = mock(HttpClient.class);
            Version version = new Version(httpClient);

            when(httpClient.send(any(), any())).thenThrow(new RuntimeException("Found Runtime Exception"));
            version.getReleaseVersion("");
        } catch (RuntimeException exception) {
            Assertions.assertEquals("Found Runtime Exception", exception.getMessage());
        }
    }
}
