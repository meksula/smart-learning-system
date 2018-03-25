package org.smartlearning.domain.statistics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.smartlearning.domain.content.time.TimeFormatter;
import org.smartlearning.domain.dto.Task;
import org.smartlearning.domain.dto.TimeLog;
import org.smartlearning.domain.user.extenders.SystemUserStatistics;
import org.smartlearning.repositories.interfaces.SystemUserStatsRepository;
import org.smartlearning.repositories.interfaces.TasksToDoRepository;
import org.smartlearning.repositories.interfaces.TimeLogRepository;
import org.smartlearning.repositories.temporary.BasicDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *@Author
 * Karol Meksuła
 * 25-03-2018
 * */

@Service
public class StatisticsProcessor {
    private SystemUserStatsRepository repository;
    private SystemUserStatistics systemUserStatistics;
    private TasksToDoRepository tasksToDoRepository;

    public StatisticsProcessor(SystemUserStatsRepository repository) {
        this.repository = repository;
    }

    public StatsRepresentation retriveStatistics(long userId) {
        systemUserStatistics = repository.fetchStatistics(userId);
        return prepareStatsObject();
    }

    private StatsRepresentation prepareStatsObject() {
        StatsRepresentation statsRepresentation = new StatsRepresentation();
        statsRepresentation.setAllSessions(String.valueOf(systemUserStatistics.getAllSessions()));
        statsRepresentation.setAllDays(String.valueOf(systemUserStatistics.getAllDays()));
        statsRepresentation.setTasksDone(String.valueOf(systemUserStatistics.getTasksDone()));
        statsRepresentation.setTasksNotDoneYet(String.valueOf(systemUserStatistics.getTasksNotDoneYet()));
        statsRepresentation.setBestDay(String.valueOf(systemUserStatistics.getBestDay()));
        statsRepresentation.setWorstDay(String.valueOf(systemUserStatistics.getWorstDay()));
        statsRepresentation.setTotalLearningTimeFormated(formatLearningTime());
        statsRepresentation.setEverageTimeInMinutesByDay(evgPerDay());
        statsRepresentation.setEverageTimeInMinutesByWeek(evgPerWeek());
        statsRepresentation.setEverageTimeInMinutesByMonth(evgPerMonth());
        statsRepresentation.setFavouriteBranchOfScience(systemUserStatistics.getFavouriteBranchOfScience());
        statsRepresentation.setCurrentsWorkOn(currentWorksOn());
        return statsRepresentation;
    }


    private String formatLearningTime() {
        TimeFormatter timeFormatter = TimeFormatter.getInstance();
        long minutes = systemUserStatistics.getTotalLearningTimeInMinutes();
        return timeFormatter.formatTimeFromMinutes(minutes);
    }

    private String evgPerDay() {
        int days = systemUserStatistics.getAllDays();
        long time = systemUserStatistics.getTotalLearningTimeInMinutes();

        if (days == 0)
            return String.valueOf(0);

        long evg = time / days;

        return String.valueOf(evg);
    }

    private TimeLogRepository timeLogRepository;

    @Autowired
    public void setTimeLogRepository(TimeLogRepository timeLogRepository) {
        this.timeLogRepository = timeLogRepository;
    }

    private String evgPerWeek() {
        final int days = 7;
        long time = extractTimeFromLastWeek();

        long evg = time / days;
        return String.valueOf(evg);
    }

    private BasicDataHandler basicDataHandler;

    @Autowired
    public void setBasicDataHandler(BasicDataHandler basicDataHandler) {
        this.basicDataHandler = basicDataHandler;
    }

    private final Logger logger = LogManager.getLogger(StatisticsProcessor.class);

    protected long extractTimeFromLastWeek() {
        List<TimeLog> logList = fetchLogListLastDays(7);
        long totalTimeByWeek = 0;

        for (int i = 0; i < logList.size(); i++) {
            totalTimeByWeek = totalTimeByWeek + logList.get(i).getLearnTimeThisDay();
        }

        return totalTimeByWeek;
    }

    private List<TimeLog> fetchLogListLastDays(int days) {
        List<TimeLog> logList = new ArrayList<>();
        LocalDate day = LocalDate.now();

        for(int i = 0; i < days; i++) {
            day = day.minusDays(1);
            try {
                List<TimeLog> logs = timeLogRepository
                        .fetchOneByLocalDate(basicDataHandler.getUserId(), day);
                logList.addAll(logs);
            } catch (EmptyResultDataAccessException e) {
                logger.info("No log with date: " + day);
            }
        }
        return logList;
    }

    private String evgPerMonth() {
        int days = LocalDate.now().lengthOfMonth();
        List<TimeLog> logList = fetchLogListLastDays(days);
        long totalTimeByMonth = 0;

        for (int i = 0; i < logList.size(); i++) {
            totalTimeByMonth = totalTimeByMonth + logList.get(i).getLearnTimeThisDay();
        }

        long evg = totalTimeByMonth / days;
        return String.valueOf(evg);
    }

    @Autowired
    public void setTasksToDoRepository(TasksToDoRepository tasksToDoRepository) {
        this.tasksToDoRepository = tasksToDoRepository;
    }

    private String currentWorksOn() {
        List<Task> tasks = tasksToDoRepository.fetchTasksToDo(basicDataHandler.getUserId());
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < tasks.size(); i++) {
            String branch = tasks.get(i).getBranchOfScience();
            builder.append(branch).append(", ");
        }

        return builder.toString();
    }

}
