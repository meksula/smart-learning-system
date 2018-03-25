package org.smartlearning.domain.content.time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author
 * Karol Meksuła
 * 21-03-2018
 * */

public class TimeFormatter {
    private final Logger logger = LogManager.getLogger(TimeFormatter.class);
    private static TimeFormatter ourInstance = new TimeFormatter();

    public static TimeFormatter getInstance() {
        return ourInstance;
    }

    private TimeFormatter() {
    }

    public String formatTimeFromSeconds(long seconds) {
        int hour = (int) (seconds / 3600);
        int minute = (int) (seconds - (hour * 3600)) / 60;
        int second = (int) (seconds - ((hour * 3600) + (minute * 60)));

        LocalTime localTime = LocalTime.of(hour, minute, second);
        localTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        return localTime.toString();
    }

    public String formatTimeFromMinutes(long minutes) {
        int hours = (int)minutes / 60;
        int minute = (int)minutes - (hours * 60);

        LocalTime localTime = LocalTime.of(hours, minute);
        localTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        return localTime.toString();
    }
}
