package org.smartlearning.domain.dto;

/**
 *@Author
 * Karol Meksuła
 * 25-03-2018
 * */

public class TimeLog {
    private long userId;
    private int year;
    private int month;
    private int day;
    private long learnTimeThisDay;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public long getLearnTimeThisDay() {
        return learnTimeThisDay;
    }

    public void setLearnTimeThisDay(long learnTimeThisDay) {
        this.learnTimeThisDay = learnTimeThisDay;
    }
}
