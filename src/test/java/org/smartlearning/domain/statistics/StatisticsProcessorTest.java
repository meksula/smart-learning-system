package org.smartlearning.domain.statistics;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.dto.TimeLog;
import org.smartlearning.repositories.interfaces.TimeLogRepository;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mock;

/**
  * @Author
  * Karol Meksuła
  * 25-03-2018
  * * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class StatisticsProcessorTest {
    private final int LIST_SIZE_EXPCT = 16;
    private final long DEF_TEST_ID = 1;
    private final long USER_ID = 900;
    private final long TIME_A = 500;
    private final long TIME_B = 600;
    private final long EXP_RESULT = TIME_A + TIME_B;

    @Autowired
    private StatisticsProcessor statisticsProcessor;

    @Autowired
    private TimeLogRepository timeLogRepository;

    @Test
    public void injectCorrectly() {
        assertNotNull(statisticsProcessor);
    }

    @Test
    public void shouldReturnListOfPropertiesToDisplay() {
        int listSize = statisticsProcessor.retriveStatistics(DEF_TEST_ID).size();
        assertEquals(LIST_SIZE_EXPCT, listSize);
    }

    @Test
    public void evgPerDayTest() {

    }

    private void fillDatabaseWithTmpData() {
        LocalDate localDate = LocalDate.now().minusDays(2);
        LocalDate localDate1 = LocalDate.now().minusDays(4);

        TimeLog timeLog = new TimeLog();
        timeLog.setUserId(USER_ID);
        timeLog.setYear(localDate.getYear());
        timeLog.setMonth(localDate.getMonthValue());
        timeLog.setDay(localDate.getDayOfMonth());
        timeLog.setLearnTimeThisDay(TIME_A);

        TimeLog timeLog1 = new TimeLog();
        timeLog1.setUserId(USER_ID);
        timeLog1.setYear(localDate1.getYear());
        timeLog1.setMonth(localDate1.getMonthValue());
        timeLog1.setDay(localDate1.getDayOfMonth());
        timeLog1.setLearnTimeThisDay(TIME_B);

        timeLogRepository.saveTimeLog(timeLog);
        timeLogRepository.saveTimeLog(timeLog1);
    }

    @Test
    public void extractTimeByWeekTest() {
        fillDatabaseWithTmpData();
        long weekTime = statisticsProcessor.extractTimeFromLastWeek();
        assertEquals(EXP_RESULT, weekTime);
    }

    @After
    public void cleanUp() {
        timeLogRepository.deleteLogList(USER_ID);
    }

}