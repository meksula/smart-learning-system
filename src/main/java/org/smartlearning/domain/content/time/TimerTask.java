package org.smartlearning.domain.content.time;

/**
 * @Author Karol Meksuła
 * 11-03-2018
 **/

public interface TimerTask {

    void appointStartTime();

    void appointEndTime();

    long summarize();
}
