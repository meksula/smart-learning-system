package org.smartlearning.core.content.meassure;

/**
 * @Author Karol Meksuła
 * 11-03-2018
 **/

public interface TimerTask {

    void appointStartTime();

    void appointEndTime();

    long summarize();
}
