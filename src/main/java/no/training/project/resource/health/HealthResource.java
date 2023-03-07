package no.training.project.resource.health;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/health")
public class HealthResource
{
    private static final Logger LOG = LoggerFactory.getLogger(HealthResource.class);
    @GET
    @Path("")
    public String getHealth()
    {
        LOG.debug("Returns a string healthy");
        return "Healthy";
    }
}
