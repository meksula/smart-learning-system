package org.smartlearning.repositories.interfaces;

import org.smartlearning.domain.user.extenders.SystemUserStatistics;

/**
 * @Author Karol Meksuła
 * 09-03-2018
 **/

public interface SystemUserStatsRepository {
    void saveStatistics(SystemUserStatistics systemUserStatistics);

    void updateStatistics(SystemUserStatistics systemUserStatistics);

    SystemUserStatistics fetchStatistics(long userId);

    void deleteSystemUserStats(long user_id);
}
