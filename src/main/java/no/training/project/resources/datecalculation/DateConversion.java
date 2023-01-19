package no.training.project.resources.datecalculation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.ChronoUnit.DAYS;

@Path("/date-conversion")
public class DateConversion {
    private static final Logger log = LoggerFactory.getLogger(DateConversion.class);
    private static final LocalDate referenceDate = LocalDate.of(2012, 8, 6);
    private static final long earthDayInSeconds = TimeUnit.DAYS.toSeconds(1);
    private static final double martianDayInSeconds = 88775.245;

    @GET
    @Path("/")
    public long calculateSol(@QueryParam("date") String date) {


        try {
            log.info("Given input is {}", date);
            LocalDate inputDate;

            if (date == null) {
                log.debug("Given input date is null");
                inputDate = LocalDate.now();
            } else {
                log.debug("Given input date is not null");
                inputDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
                log.debug("Given input date is parsed to LocalDate");
            }
            long diff = DAYS.between(referenceDate, inputDate);
            log.info("Difference between given date reference date in days is {}", diff);
            long sol = (long) Math.ceil(diff * earthDayInSeconds / martianDayInSeconds);
            log.info("Calculated sol using thee given formula is {}", sol);
            return sol;
        } catch (Exception e) {
            log.error("unexpected error while calculating sol,", e);
            throw new RuntimeException("Unexpected error while calculating sol :", e);
        }
    }
}

