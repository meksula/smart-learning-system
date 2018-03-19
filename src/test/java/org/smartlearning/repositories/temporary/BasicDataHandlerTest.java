package org.smartlearning.repositories.temporary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 10-03-2018
 **/

public class BasicDataHandlerTest {
    private BasicDataHandler basicDataHandler = new BasicDataHandler();
    private final String username = "basia84";
    private final long userId = 10393;
    private final long taskId = 3642224;

    @Test
    public void shouldSetCorrectlyValues() {
        basicDataHandler.setTaskId((int) taskId);
        basicDataHandler.setUserId(userId);
        basicDataHandler.setUsername(username);

        assertEquals(username, basicDataHandler.getUsername());
        assertEquals(userId, basicDataHandler.getUserId());
        assertEquals(taskId, basicDataHandler.getTaskId());
    }
}