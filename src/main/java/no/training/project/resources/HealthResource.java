package no.training.project.resources;

import org.glassfish.grizzly.http.util.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class HealthResource {
    @GET
    @Path("/health")
    public HttpStatus getHealth(){
        return HttpStatus.OK_200;

    }

}
