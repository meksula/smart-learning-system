package org.smartlearning.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.smartlearning.domain.content.Task;
import org.smartlearning.domain.content.meassure.NanoParser;
import org.smartlearning.domain.content.meassure.TimerTask;
import org.smartlearning.repositories.interfaces.TasksToDoRepository;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTimeCountLogic {
    private BasicDataHandler basicDataHandler;
    private TasksToDoRepository tasksToDoRepository;
    private TimerTask timerTask;
    private NanoParser nanoParser;

    @Autowired
    public void setTimerTask(TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    @Autowired
    public void setTasksToDoRepository(TasksToDoRepository tasksToDoRepository) {
        this.tasksToDoRepository = tasksToDoRepository;
    }

    @Autowired
    public void setNanoParser(NanoParser nanoParser) {
        this.nanoParser = nanoParser;
    }

    @Autowired
    public void setBasicDataHandler(BasicDataHandler basicDataHandler) {
        this.basicDataHandler = basicDataHandler;
    }

    @Before("execution(* org.smartlearning.controller.LearnController.start())")
    public void measureTime() {
        timerTask.appointStartTime();
    }

    @Before("execution(* org.smartlearning.controller.LearnController.stop(..))")
    public void summary() {
        Task task = tasksToDoRepository.fetchOneTaskByTaskId(basicDataHandler.getTaskId());
        timerTask.appointEndTime();
        long sum = timerTask.summarize();
        sum = nanoParser.parseNanoToSeconds(sum);
        task.summarizeSpendTime(sum);
        tasksToDoRepository.updateTaskToDo(task);
    }
}