package org.smartlearning.repositories.implementations;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.dto.TimeLog;
import org.smartlearning.repositories.interfaces.TimeLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 *@Author
 * Karol Meksuła
 * 25-03-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TimeLogRepositoryImplTest {
    private final long USER_ID = 982883;
    private final long LEARN_TIME = 4642;

    @Autowired
    private TimeLogRepository timeLogRepository;

    @Test
    public void shouldCorrectlySaveOneLog() {
        timeLogRepository.saveTimeLog(prepareTestLog());
        List<TimeLog> timeLog = timeLogRepository.fetchTimeLog(USER_ID);
        assertEquals(1, timeLog.size());
        cleanUp();
    }

    @Test
    public void shouldCorrectlyFetchListOfLog() {
        timeLogRepository.saveTimeLog(prepareTestLog());
        List<TimeLog> logs = timeLogRepository.fetchTimeLog(USER_ID);
        assertEquals(1, logs.size());
        cleanUp();
    }

    @Test
    public void shouldCorrectlyFetchByLocalDateOneLog() {
        putPreparedTestData();
        List<TimeLog> timeLog = timeLogRepository.fetchOneByLocalDate(USER_ID, LocalDate.of(2015,4,18));
        assertEquals(1, timeLog.size());
    }

    @After
    public void cleanUp() {
        timeLogRepository.deleteLogList(USER_ID);
    }

    private TimeLog prepareTestLog() {
        TimeLog timeLog = new TimeLog();
        timeLog.setUserId(USER_ID);
        timeLog.setYear(LocalDate.now().getYear());
        timeLog.setMonth(LocalDate.now().getMonthValue());
        timeLog.setDay(LocalDate.now().getDayOfMonth());
        timeLog.setLearnTimeThisDay(LEARN_TIME);
        return timeLog;
    }

    private void putPreparedTestData() {
        TimeLog timeLog = new TimeLog();
        timeLog.setUserId(USER_ID);
        timeLog.setYear(2015);
        timeLog.setMonth(4);
        timeLog.setDay(18);
        timeLog.setLearnTimeThisDay(938);
        timeLogRepository.saveTimeLog(timeLog);
    }

}