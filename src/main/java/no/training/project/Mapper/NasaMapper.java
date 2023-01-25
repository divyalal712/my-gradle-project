package no.training.project.Mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.training.project.model.ExternalResponse;
import no.training.project.resource.datecalculation.DateConversion;
import org.apache.log4j.helpers.LogLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.http.HttpResponse;

public class NasaMapper {
    private static final Logger LOG = LoggerFactory.getLogger(NasaMapper.class);

    public ExternalResponse getNasaObject(HttpResponse<String> response) {
        ObjectMapper objectMapper = new ObjectMapper();
        ExternalResponse resp;
        try {
            resp = objectMapper.readValue(response.body(), ExternalResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        LOG.info("The response is converted to string is {} ", resp.toString());
        return resp;
    }
}







