package no.training.project.Mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.training.project.model.Release;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpResponse;

public class ReleaseMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(ReleaseMapper.class);
    public Release getReleaseMapperObject(HttpResponse<String> response){
        Release release;
        try {
            release = objectMapper.readValue(response.body(), Release.class);
        } catch (JsonProcessingException e) {
            LOG.error("The error in converting Json to object is: {}",e.getMessage());
            throw new RuntimeException(e);
        }
        LOG.debug("The response is {}",release);
        return release;
    }
}

