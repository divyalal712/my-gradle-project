package no.training.project.resources;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
public class HealthResource {
    @GET
    @Path("health")
    public String getHealth(){
        return "Healthy";
    }
}
