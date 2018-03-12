package org.smartlearning.repositories.temporary;

import org.springframework.stereotype.Service;

/**
 * @Author Karol Meksuła
 * 10-03-2018
 **/

@Service
public class BasicDataHandler {
    public long userId;
    public String username;
    private int taskId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
