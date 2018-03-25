package org.smartlearning.domain.content.time;

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
public class NanoParserTest {
    private Logger logger = LogManager.getLogger(NanoParserTest.class);

    @Autowired
    private NanoParser nanoParser;

    @Autowired
    private TimerTask timerTask;

    @Test
    public void nanoParserShouldBeNotNull() {
        assertNotNull(nanoParser);
    }

    private long appointTime() throws InterruptedException {
        timerTask.appointStartTime();
        Thread.sleep(5000);
        timerTask.appointEndTime();
        return timerTask.summarize();
    }

    @Test
    public void nanoParserShouldParseNanoToLocalTime() throws InterruptedException {
        long result = appointTime();

        long seconds = nanoParser.parseNanoToSeconds(result);
        assertEquals(5, seconds);
        logger.info("Seconds: " + seconds);
    }

}