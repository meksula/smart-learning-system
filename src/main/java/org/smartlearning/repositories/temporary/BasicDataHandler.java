package org.smartlearning.repositories.temporary;

import org.springframework.stereotype.Service;

/**
 * @Author Karol Meksuła
 * 10-03-2018
 **/

@Service
public class BasicDataHandler {
    private long userId;
    private String username;
    private int taskId;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
