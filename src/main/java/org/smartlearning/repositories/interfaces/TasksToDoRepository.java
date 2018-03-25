package org.smartlearning.repositories.interfaces;

import org.smartlearning.domain.dto.Task;

import java.util.List;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */

public interface TasksToDoRepository {
    List<Task> fetchTasksToDo(long userId);

    void saveTaskToDo(Task task);

    Task fetchOneTaskByTaskId(long taskId);

    void updateTaskToDo(Task task);

    void deleteAllUsersTasks(long userId);
}
