package org.smartlearning.domain.content.goTop;

import org.smartlearning.domain.user.extenders.SystemUserStatistics;

/**
 * @Author
 * Karol Meksuła
 * 24-03-2018
 * */

public class StatisticProcesor {
    private static StatisticProcesor ourInstance = new StatisticProcesor();

    public static StatisticProcesor getInstance() {
        return ourInstance;
    }

    private StatisticProcesor() {
    }

    private SystemUserStatistics systemUserStatistics;

    public void setSystemUserStatistic(SystemUserStatistics sus) {
        this.systemUserStatistics = sus;
    }

    public SystemUserStatistics getSus() {
        return systemUserStatistics;
    }

    protected int convertMinutesToHours() {
        return  (int)systemUserStatistics.getTotalLearningTimeInMinutes() / 60;
    }



}
