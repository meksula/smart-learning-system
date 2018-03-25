package org.smartlearning.domain.content.time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * @Author
 * Karol Meksuła
 * 21-03-2018
 * */

public class TimeFormatterTest {
    private final Logger logger = LogManager.getLogger(TimeFormatterTest.class);
    private TimeFormatter timeFormatter = TimeFormatter.getInstance();
    private final long SECONDS = 3604;
    private final long MINUTES = 601;

    @Test
    public void timeFormatterShouldGiveCorrectlyTime() {
        String timestamp = timeFormatter.formatTimeFromSeconds(SECONDS);
        logger.info(timestamp);
        assertEquals("01:00:04", timestamp);
    }

    @Test
    public void timeFormatterShouldCorrectlyFormatFromMinutes() {
        String timestamp = timeFormatter.formatTimeFromMinutes(MINUTES);
        logger.info(timestamp);
        assertEquals("10:01", timestamp);
    }
}