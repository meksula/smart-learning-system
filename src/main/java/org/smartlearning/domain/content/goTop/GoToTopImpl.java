package org.smartlearning.domain.content.goTop;

import org.smartlearning.domain.user.extenders.SystemUserStatistics;
import org.smartlearning.repositories.interfaces.SystemUserStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author
 * Karol Meksuła
 * 24-03-2018
 * */

@Component
public class GoToTopImpl implements GoToTop {
    private SystemUserStatsRepository repository;
    StatisticProcesor statisticProcesor = StatisticProcesor.getInstance();

    @Autowired
    public void setRepository(SystemUserStatsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getStats(long userId) {
        SystemUserStatistics sus = repository.fetchStatistics(userId);
        statisticProcesor.setSystemUserStatistic(sus);
    }

    @Override
    public String showMessage() {
        return null;
    }
}
