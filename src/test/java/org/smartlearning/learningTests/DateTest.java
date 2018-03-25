package org.smartlearning.learningTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.time.LocalDate;

public class DateTest {
    private final Logger logger = LogManager.getLogger(DateTest.class);

    @Test
    public void shouldReturnCorrectlyFormatDate() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        logger.info(today);
        logger.info(year + " " + " " + month + " " + day);

        for(int i = 0; i < 7; i++) {
            today = today.minusDays(1);
            logger.info(today);
        }
    }

    @Test
    public void monthLengthTest() {
        logger.info(LocalDate.now().lengthOfMonth());
    }

}
