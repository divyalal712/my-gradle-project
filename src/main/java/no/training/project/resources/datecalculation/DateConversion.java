package no.training.project.resources.datecalculation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.temporal.ChronoUnit.DAYS;

@Path("/date-conversion")
public class DateConversion {

    private static final Logger log = LoggerFactory.getLogger(DateConversion.class);

    @GET
    @Path("/")
    public long calculateSol(@QueryParam("date") String date) {
        try {
            log.info("Given input is {}", date);
            LocalDate inputDate = null;

            if (date == null) {
                log.debug("Given input date is null");
                inputDate = LocalDate.now();
            } else {
                log.debug("Given input date is not null");
                inputDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
                log.debug("Given input date is parsed to LocalDate");
            }
            LocalDate referenceDate = LocalDate.parse("2012-08-06", DateTimeFormatter.ISO_DATE);


            long diff = DAYS.between(referenceDate, inputDate);
            log.info("Difference between given date reference date in days is {}", diff);
            long sol = (long) Math.ceil(diff * 86400 / 88775.245);
            log.info("Calculated sol using thee given formula is {}", sol);
            return sol;
        } catch (Exception e) {
            log.error("unexpected error while calculating sol, {}", e);
            throw new RuntimeException("Unexpected error while calculating sol :", e);
        }
    }
}



























