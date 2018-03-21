package org.smartlearning.domain.content.meassure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 11-03-2018
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TimerTaskImplTest {
    private final Logger logger = LogManager.getLogger(TimerTaskImplTest.class);
    private final long ONE_SECOND = 1000000000;

    @Autowired
    private TimerTask timerTask;

    @Test
    public void summarizeAndReturnTimeInterval() throws InterruptedException {
        timerTask.appointStartTime();
        Thread.sleep(5000);
        timerTask.appointEndTime();

        long result = timerTask.summarize();
        assertTrue(result > (ONE_SECOND * 5));
        logger.info("Interval time: " + result);
    }
}