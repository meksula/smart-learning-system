package org.smartlearning.core.user.extenders;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

public class SystemUserStatistics {
    private long userId;
    private int allSessions;
    private int allDays;
    private int tasksDone;
    private int tasksNotDoneYet;
    private String bestDay;
    private String worstDay;
    private long totalLearningTimeInMinutes;
    private long everageTimeInMinutesByDay;
    private long everageTimeInMinutesByWeek;
    private long everageTimeInMinutesByMonth;
    private String favouriteBranchOfScience;

    public int getAllSessions() {
        return allSessions;
    }

    public void setAllSessions(int allSessions) {
        this.allSessions = allSessions;
    }

    public int getAllDays() {
        return allDays;
    }

    public void setAllDays(int allDays) {
        this.allDays = allDays;
    }

    public int getTasksDone() {
        return tasksDone;
    }

    public void setTasksDone(int tasksDone) {
        this.tasksDone = tasksDone;
    }

    public int getTasksNotDoneYet() {
        return tasksNotDoneYet;
    }

    public void setTasksNotDoneYet(int tasksNotDoneYet) {
        this.tasksNotDoneYet = tasksNotDoneYet;
    }

    public String getBestDay() {
        return bestDay;
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

    public long getTotalLearningTimeInMinutes() {
        return totalLearningTimeInMinutes;
    }

    public void setTotalLearningTimeInMinutes(long totalLearningTimeInMinutes) {
        this.totalLearningTimeInMinutes = totalLearningTimeInMinutes;
    }

    public long getEverageTimeInMinutesByDay() {
        return everageTimeInMinutesByDay;
    }

    public void setEverageTimeInMinutesByDay(long everageTimeInMinutesByDay) {
        this.everageTimeInMinutesByDay = everageTimeInMinutesByDay;
    }

    public long getEverageTimeInMinutesByWeek() {
        return everageTimeInMinutesByWeek;
    }

    public void setEverageTimeInMinutesByWeek(long everageTimeInMinutesByWeek) {
        this.everageTimeInMinutesByWeek = everageTimeInMinutesByWeek;
    }

    public long getEverageTimeInMinutesByMonth() {
        return everageTimeInMinutesByMonth;
    }

    public void setEverageTimeInMinutesByMonth(long everageTimeInMinutesByMonth) {
        this.everageTimeInMinutesByMonth = everageTimeInMinutesByMonth;
    }

    public String getFavouriteBranchOfScience() {
        return favouriteBranchOfScience;
    }

    public void setFavouriteBranchOfScience(String favouriteBranchOfScience) {
        this.favouriteBranchOfScience = favouriteBranchOfScience;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
