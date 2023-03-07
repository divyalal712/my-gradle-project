package no.training.project.Mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.training.project.model.ExternalResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpResponse;

public class NasaMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(NasaMapper.class);

    public ExternalResponse getNasaObject(HttpResponse<String> response) {
        ExternalResponse resp;
        try {
            resp = objectMapper.readValue(response.body(), ExternalResponse.class);
        } catch (JsonProcessingException e) {
            LOG.error("Error in parsing Json to object : {}", e.getMessage());
            throw new RuntimeException(e);
        }
        LOG.debug("The response is converted to ExternalResponse and is {} ",resp);
        return resp;
    }
}