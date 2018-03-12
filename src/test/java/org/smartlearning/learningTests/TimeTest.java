package org.smartlearning.learningTests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.time.LocalTime;

/**
 * @Author Karol Meksuła
 * 11-03-2018
 **/

public class TimeTest {
    private final Logger logger = LogManager.getLogger(TimeTest.class);

    @Test
    public void timer() throws InterruptedException {
        long startTime = System.nanoTime();
        logger.info(startTime);
        Thread.sleep(5000);

        long endTime = System.nanoTime();
        logger.info(endTime);

        long result = endTime - startTime;
        logger.info("Time: " + result);

        LocalTime parsed = LocalTime.ofNanoOfDay(result);
        logger.info(parsed);
    }
}
