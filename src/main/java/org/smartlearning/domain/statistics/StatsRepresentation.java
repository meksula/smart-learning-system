package org.smartlearning.domain.statistics;

/**
 * @Author
 * Karol Meksuła
 * 25-03-2018
 * */

public class StatsRepresentation {
    private String allSessions;
    private String allDays;
    private String tasksDone;
    private String tasksNotDoneYet;
    private String bestDay;
    private String worstDay;
    private String totalLearningTimeFormated;
    private String everageTimeInMinutesByDay;
    private String everageTimeInMinutesByWeek;
    private String everageTimeInMinutesByMonth;
    private String favouriteBranchOfScience;
    private String currentsWorkOn;

    public String getAllDays() {
        return allDays;
    }

    public String getAllSessions() {
        return allSessions;
    }

    public String getBestDay() {
        return bestDay;
    }

    public void setAllSessions(String allSessions) {
        this.allSessions = allSessions;
    }

    public void setAllDays(String allDays) {
        this.allDays = allDays;
    }

    public String getTasksDone() {
        return tasksDone;
    }

    public void setTasksDone(String tasksDone) {
        this.tasksDone = tasksDone;
    }

    public String getTasksNotDoneYet() {
        return tasksNotDoneYet;
    }

    public void setTasksNotDoneYet(String tasksNotDoneYet) {
        this.tasksNotDoneYet = tasksNotDoneYet;
    }

    public void setBestDay(String bestDay) {
        this.bestDay = bestDay;
    }

    public String getWorstDay() {
        return worstDay;
    }

    public void setWorstDay(String worstDay) {
        this.worstDay = worstDay;
    }

    public String getEverageTimeInMinutesByDay() {
        return everageTimeInMinutesByDay;
    }

    public void setEverageTimeInMinutesByDay(String everageTimeInMinutesByDay) {
        this.everageTimeInMinutesByDay = everageTimeInMinutesByDay;
    }

    public String getEverageTimeInMinutesByWeek() {
        return everageTimeInMinutesByWeek;
    }

    public void setEverageTimeInMinutesByWeek(String everageTimeInMinutesByWeek) {
        this.everageTimeInMinutesByWeek = everageTimeInMinutesByWeek;
    }

    public String getEverageTimeInMinutesByMonth() {
        return everageTimeInMinutesByMonth;
    }

    public void setEverageTimeInMinutesByMonth(String everageTimeInMinutesByMonth) {
        this.everageTimeInMinutesByMonth = everageTimeInMinutesByMonth;
    }

    public String getFavouriteBranchOfScience() {
        return favouriteBranchOfScience;
    }

    public void setFavouriteBranchOfScience(String favouriteBranchOfScience) {
        this.favouriteBranchOfScience = favouriteBranchOfScience;
    }

    public String getTotalLearningTimeFormated() {
        return totalLearningTimeFormated;
    }

    public void setTotalLearningTimeFormated(String totalLearningTimeFormated) {
        this.totalLearningTimeFormated = totalLearningTimeFormated;
    }

    public String getCurrentsWorkOn() {
        return currentsWorkOn;
    }

    public void setCurrentsWorkOn(String currentsWorkOn) {
        this.currentsWorkOn = currentsWorkOn;
    }
}

