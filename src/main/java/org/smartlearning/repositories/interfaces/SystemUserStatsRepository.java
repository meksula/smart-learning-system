package org.smartlearning.repositories.interfaces;

import org.smartlearning.core.user.SystemUserStatistics;

/**
 * @Author Karol Meksuła
 * 09-03-2018
 **/

public interface SystemUserStatsRepository {
    void saveStatistics(SystemUserStatistics systemUserStatistics);

    void updateStatistics(SystemUserStatistics systemUserStatistics);

    SystemUserStatistics fetchStatistics(long userId);

}
