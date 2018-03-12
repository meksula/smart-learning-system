package org.smartlearning.repositories.interfaces;

import org.smartlearning.core.content.Task;

import java.util.List;

public interface TasksToDoRepository {
    List<Task> fetchTasksToDo(long userId);

    void saveTaskToDo(Task task);

    Task fetchOneTaskByTaskId(long taskId);

    void updateTaskToDo(Task task);
}
