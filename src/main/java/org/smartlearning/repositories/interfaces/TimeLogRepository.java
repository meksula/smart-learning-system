package org.smartlearning.repositories.interfaces;

import org.smartlearning.domain.dto.TimeLog;

import java.time.LocalDate;
import java.util.List;

/**
 *@Author
 * Karol Meksuła
 * 25-03-2018
 * */

public interface TimeLogRepository {
    void saveTimeLog(TimeLog timeLog);

    List<TimeLog> fetchTimeLog(long userId);


    List<TimeLog> fetchOneByLocalDate(long userId, LocalDate localDate);

    void deleteLogList(long userId);
}
