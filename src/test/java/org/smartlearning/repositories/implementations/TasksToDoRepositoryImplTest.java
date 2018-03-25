package org.smartlearning.repositories.implementations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.dto.Task;
import org.smartlearning.domain.user.SystemUser;
import org.smartlearning.repositories.interfaces.TasksToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TasksToDoRepositoryImplTest {
    private SystemUser systemUser;
    private final long USER_ID = 23948;

    @Autowired
    private TasksToDoRepository tasksToDoRepository;

    @Before
    public void setUp() {
        systemUser = new SystemUser();
        systemUser.setName("Pablo");
        systemUser.setUserId(USER_ID);
    }

    @Test
    public void preconditionsTest() {
        assertEquals("Pablo", systemUser.getName());
        assertEquals(USER_ID, systemUser.getUserId());
    }

    private Task createTask() {
        Task task = new Task();
        task.setUserId(USER_ID);
        return task;
    }

    @Test
    public void daoShouldSaveTasksCorrectly() {
        tasksToDoRepository.saveTaskToDo(createTask());
        List<Task> task = tasksToDoRepository.fetchTasksToDo(USER_ID);
        assertTrue(task.size() == 1);
        assertEquals(USER_ID, task.get(0).getUserId());
    }

    @Test
    public void daoShouldFetchTasksCorrectly() {
        for (int i = 0; i < 2; i++) {
            tasksToDoRepository.saveTaskToDo(createTask());
        }
        List<Task> tasks = tasksToDoRepository.fetchTasksToDo(USER_ID);
        assertEquals(2, tasks.size());
    }

    @Test
    public void spendedTimeShouldBeUpdated() {
        final long ADD_TIME = 3000;
        Task task = tasksToDoRepository.fetchOneTaskByTaskId(1);
        long time = task.getSpendTime();

        task.summarizeSpendTime(ADD_TIME);
        tasksToDoRepository.updateTaskToDo(task);

        assertEquals(time + ADD_TIME, task.getSpendTime());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void daoShouldDeleteAllUsersTasks() {
        tasksToDoRepository.deleteAllUsersTasks(USER_ID);
        tasksToDoRepository.fetchTasksToDo(USER_ID);
    }

    @After
    public void cleanUp() {
        tasksToDoRepository.deleteAllUsersTasks(USER_ID);
    }

}