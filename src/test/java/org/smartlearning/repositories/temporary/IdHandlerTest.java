package org.smartlearning.repositories.temporary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

public class IdHandlerTest {
    private IdHandler idHandler = new IdHandler();
    private final long taskId = 2149112;

    @Test
    public void shouldBeAbleToAddIdAndReturn() {
        idHandler.setId(taskId);

        assertEquals(taskId, idHandler.getId());
    }
}