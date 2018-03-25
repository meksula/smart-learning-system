package org.smartlearning.domain.content.goTop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.user.SystemUser;
import org.smartlearning.domain.user.extenders.SystemUserStatistics;
import org.smartlearning.repositories.interfaces.SystemUserStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @Author
 * Karol Meksuła
 * 24-03-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class StatisticProcesorTest {
    private final Logger logger = LogManager.getLogger(StatisticProcesorTest.class);
    private StatisticProcesor statisticProcesor = StatisticProcesor.getInstance();
    private SystemUserStatistics systemUserStatistics = mock(SystemUserStatistics.class);
    private final long USER_ID = 1;

    @Autowired
    private SystemUserStatsRepository repository;

    @Test
    public void setterTest() {
        statisticProcesor.setSystemUserStatistic(repository.fetchStatistics(USER_ID));
        assertNotNull(statisticProcesor.getSus());
    }

    @Test
    public void timeConvertTest() {
        statisticProcesor.setSystemUserStatistic(repository.fetchStatistics(USER_ID));

        int hours = statisticProcesor.convertMinutesToHours();
        assertEquals(0, hours);
    }

    @Test
    public void timeConvertTestWithMock() {
        statisticProcesor.setSystemUserStatistic(systemUserStatistics);
        when(systemUserStatistics.getTotalLearningTimeInMinutes()).thenReturn(49837l);

        logger.info(systemUserStatistics.getTotalLearningTimeInMinutes());
        int hours = statisticProcesor.convertMinutesToHours();
        assertEquals(830, hours);
    }
}