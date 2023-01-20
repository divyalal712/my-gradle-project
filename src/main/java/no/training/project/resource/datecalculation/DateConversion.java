package no.training.project.resource.datecalculation;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.format.DateTimeFormatter.ISO_DATE;

@Path("/date-conversion")
public class DateConversion {
    private static final Logger LOG = LoggerFactory.getLogger(DateConversion.class);
    private static final LocalDate REFERENCE_DATE = LocalDate.of(2012, 8, 6);
    private static final long EARTHDAYINSECONDS = TimeUnit.DAYS.toSeconds(1);
    private static final double MARTIANDAYINSECONDS = 88775.245;

    @GET
    @Path("/")
    public long calculateSol(@QueryParam("date") String date) {
        try {
            LOG.info("Given input is {}", date);
            LocalDate inputDate;

            if (date == null) {
                LOG.debug("Given input date is null");
                inputDate = LocalDate.now();
            } else {
                LOG.debug("Given input date is not null");
                inputDate = LocalDate.parse(date,ISO_DATE);
                LOG.debug("Given input date is parsed to LocalDate");
            }
            long diff = DAYS.between(REFERENCE_DATE, inputDate);
            LOG.info("Difference between given date reference date in days is {}", diff);
            long sol = (long) Math.ceil(diff * EARTHDAYINSECONDS / MARTIANDAYINSECONDS);
            LOG.info("Calculated sol using thee given formula is {}", sol);
            return sol;
        } catch (Exception e) {
            LOG.error("unexpected error while calculating sol,", e);
            throw new RuntimeException("Unexpected error while calculating sol :", e);
        }
    }
}
