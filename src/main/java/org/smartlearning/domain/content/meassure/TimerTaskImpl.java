package org.smartlearning.domain.content.meassure;

import org.springframework.stereotype.Service;

/**
 * @Author Karol Meksuła
 * 11-03-2018
 **/

@Service
public class TimerTaskImpl implements TimerTask {
    private long startTime;
    private long endTime;

    @Override
    public void appointStartTime() {
        startTime = System.nanoTime();
    }

    @Override
    public void appointEndTime() {
        endTime = System.nanoTime();
    }

    @Override
    public long summarize() {
        return endTime - startTime;
    }
}
