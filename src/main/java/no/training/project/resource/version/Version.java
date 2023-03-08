package no.training.project.resource.version;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import no.training.project.Mapper.ReleaseMapper;
import no.training.project.exception.ServiceException;
import no.training.project.model.Release;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Path("/release-name")
public class Version {
    private static final String JAVA_VERSION_URI = "https://api.adoptopenjdk.net/v3/info/release_names?architecture=%s&heap" +
            "_size=normal&image_type=jdk&page=2&page_size=10&project=jdk&release_type=ga" +
            "&sort_method=DEFAULT&sort_order=DESC&vendor=adoptopenjdk";
    private static final Logger LOG = LoggerFactory.getLogger(Version.class);
    private HttpClient httpClient;

    public Version(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Version() {
        this.httpClient = HttpClient.newHttpClient();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Release getReleaseVersion(@QueryParam("architecture") @DefaultValue("x32") String architecture)
            throws IOException, InterruptedException, ServiceException {
        try {
            String uri = String.format(JAVA_VERSION_URI, architecture);
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri))
                    .method("GET", HttpRequest.BodyPublishers.noBody()).build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                ReleaseMapper releaseMapper = new ReleaseMapper();
                Release releases = releaseMapper.getReleaseMapperObject(response);
                LOG.debug("Returns the external response: {}", releases != null);
                return releases;
            } else {
                throw new ServiceException("Internal error found", response.statusCode());
            }
        } catch (Exception e) {
            LOG.error("Exception found", e);
            throw e;
        }
    }
}
