package no.training.project;

import no.training.project.resources.HealthResource;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Application {

    public static final String BASE_URI = "http://localhost:8080/";

    public static void main(String[] args) {
        final ResourceConfig config = new ResourceConfig();
        config.register(HealthResource.class);

        final HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        httpServer.shutdownNow();
    }

}
