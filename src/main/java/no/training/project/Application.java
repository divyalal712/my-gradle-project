package no.training.project;

import no.training.project.resources.datecalculation.DateConversion;
import no.training.project.resources.health.HealthResource;
import org.apache.log4j.BasicConfigurator;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import java.io.IOException;
import java.net.URI;

public class Application {

    public static final URI BASE_URI = URI.create("http://localhost:8080");



    public static void main(String[] args) {
        ResourceConfig config = new ResourceConfig();
        config.register(HealthResource.class);
        config.register(DateConversion.class);


         HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, config);
        try {
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        httpServer.shutdownNow();
    }


}
