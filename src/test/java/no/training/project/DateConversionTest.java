package no.training.project;

import no.training.project.resources.datecalculation.DateConversion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateConversionTest {
    @Test
    public void testSolWithDateInput() {
        DateConversion date = new DateConversion();
        long sol = date.calculateSol("2022-06-15");
        Assertions.assertEquals(3504, sol);
    }

    @Test
    public void testSolNull() {
        DateConversion date = new DateConversion();
        long sol = date.calculateSol(null);
        Assertions.assertTrue(sol > 0);
    }

    @Test
    public void testSameReference() {
        DateConversion date = new DateConversion();
        long sol = date.calculateSol("2012-08-06");
        Assertions.assertEquals(0, sol);
    }
        @Test
    public void testException() {
        try {
            DateConversion date = new DateConversion();
            long sol = date.calculateSol("2012-08-33");
        } catch (Exception e) {
            Assertions.assertEquals("Unexpected error while calculating sol :", e.getMessage());
        }
    }

    @Test
    public void testSolFormat() {
        try {
            DateConversion date = new DateConversion();
            long sol = date.calculateSol("16-08-2020");
        } catch (Exception e) {
            Assertions.assertEquals("Unexpected error while calculating sol :", e.getMessage());
        }
    }




}








