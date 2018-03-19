package org.smartlearning.domain.content;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

public class Task {
    private long taskId;
    private long userId;
    private String title;
    private String description;
    private long spendTimeInSeconds;
    private String branchOfScience;
    private String startDate;
    private String finishDate;

    public void summarizeSpendTime(long seconds) {
        this.spendTimeInSeconds = this.spendTimeInSeconds + seconds;
    }

    public long getSpendTime() {
        return spendTimeInSeconds;
    }

    public void setSpendTime(long spendTime) {
        this.spendTimeInSeconds = spendTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getBranchOfScience() {
        return branchOfScience;
    }

    public void setBranchOfScience(String branchOfScience) {
        this.branchOfScience = branchOfScience;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public List<String> summaryList() {
        ArrayList<String> summary = new ArrayList<>();
        summary.add("Task: " + title);
        summary.add("Time spend by this task: " + spendTimeInSeconds);
        return summary;
    }
}
