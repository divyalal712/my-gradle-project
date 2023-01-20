package no.training.project.resources.health;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import no.training.project.resources.datecalculation.DateConversion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/health")
public class HealthResource
{
    private static final Logger log = LoggerFactory.getLogger(HealthResource.class);
    @GET
    @Path("")
    public String getHealth()
    {
        log.debug("Returns a string healthy");
        return "Healthy";
    }
}

