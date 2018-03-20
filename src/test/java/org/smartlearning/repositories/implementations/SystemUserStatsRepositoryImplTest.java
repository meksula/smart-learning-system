package org.smartlearning.repositories.implementations;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.user.extenders.SystemUserStatistics;
import org.smartlearning.repositories.interfaces.SystemUserStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 08-03-2018
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class SystemUserStatsRepositoryImplTest {
    private final long USER_ID = 36828;
    private final long TIME = 422554;

    @Autowired
    private SystemUserStatsRepository systemUserStatsRepository;

    private SystemUserStatistics createStats() {
        SystemUserStatistics systemUserStatistics = new SystemUserStatistics();
        systemUserStatistics.setUserId(USER_ID);
        systemUserStatistics.setAllSessions(34);
        systemUserStatistics.setAllDays(43);
        systemUserStatistics.setTasksDone(54);
        systemUserStatistics.setTasksNotDoneYet(2);
        systemUserStatistics.setBestDay("today");
        systemUserStatistics.setWorstDay("Never");
        systemUserStatistics.setTotalLearningTimeInMinutes(TIME);
        systemUserStatistics.setFavouriteBranchOfScience("IT");
        return systemUserStatistics;
    }

    @Test
    public void saveSystemUsersStatistics() {
        systemUserStatsRepository.saveStatistics(createStats());
        SystemUserStatistics statistics = systemUserStatsRepository.fetchStatistics(USER_ID);
        assertNotNull(statistics);
        assertEquals(USER_ID, statistics.getUserId());
        assertEquals(TIME, statistics.getTotalLearningTimeInMinutes());
    }

    private void changeValues(SystemUserStatistics systemUserStatistics) {
        systemUserStatistics.setAllDays(systemUserStatistics.getAllDays() + 100);
    }

    @Test
    public void updateShouldWorkCorrectly() {
        systemUserStatsRepository.updateStatistics(createStats());
        SystemUserStatistics statistics = systemUserStatsRepository.fetchStatistics(USER_ID);
        changeValues(statistics);
        assertEquals(143, statistics.getAllDays());
    }


    @After
    public void cleanUp() {
        systemUserStatsRepository.deleteSystemUserStats(USER_ID);
    }
}