package no.training.project;

import no.training.project.resource.health.HealthResource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealthResourceTest {
    @Test
    public void testGetHealth(){
        HealthResource health = new HealthResource();
        String actual = health.getHealth();
        Assertions.assertEquals("Healthy",actual);
    }
}
