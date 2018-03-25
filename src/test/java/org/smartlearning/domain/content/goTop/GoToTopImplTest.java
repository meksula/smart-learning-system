package org.smartlearning.domain.content.goTop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.user.extenders.SystemUserStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 24-03-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class GoToTopImplTest {
    private final long USER_ID = 1;

    @Autowired
    private GoToTop goToTop;

    @Test
    public void notNullTest() {
        assertNotNull(goToTop);
    }

    @Test
    public void shouldCorrectlyFetchDataFromDB() {
        goToTop.getStats(USER_ID);
    }

    @Test
    public void shouldCorrectlyReturnData() {

    }

}