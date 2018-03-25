package org.smartlearning.domain.content.goTop;

import org.smartlearning.domain.user.extenders.SystemUserStatistics;

/**
 * @Author
 * Karol Meksuła
 * 23-03-2018
 * * */

public interface GoToTop {
    void getStats(long userId);

    String showMessage();
}
