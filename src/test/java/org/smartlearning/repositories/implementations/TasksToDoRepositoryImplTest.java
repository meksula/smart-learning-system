package org.smartlearning.repositories.implementations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.configuration.WebApplicationInitializer;
import org.smartlearning.configuration.WebApplicationServletConfiguration;
import org.smartlearning.core.content.Task;
import org.smartlearning.repositories.interfaces.TasksToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebApplicationInitializer.class,
        WebApplicationServletConfiguration.class, RootConfig.class})
public class TasksToDoRepositoryImplTest {

    @Autowired
    private TasksToDoRepository tasksToDoRepository;

    @Test
    public void spendedTimeShouldBeUpdated() {
        Task task = tasksToDoRepository.fetchOneTaskByTaskId(2);
        task.summarizeSpendTime(3000);
        tasksToDoRepository.updateTaskToDo(task);
    }
}