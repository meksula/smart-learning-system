package org.smartlearning.repositories.implementations;

import org.smartlearning.domain.dto.TimeLog;
import org.smartlearning.repositories.interfaces.TimeLogRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *@Author
 * Karol Meksuła
 * 25-03-2018
 * */

@Repository
public class TimeLogRepositoryImpl implements TimeLogRepository {
    private JdbcOperations jdbcOperations;

    public TimeLogRepositoryImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private final String FETCH_QUERY = "SELECT * FROM time_log WHERE userId=?";
    private final String FETCH_QUERY_DATE = "SELECT * FROM time_log WHERE userId=? AND year=? AND month=? AND day=?";
    private final String SAVE_QUERY = "INSERT INTO time_log (userId, year, month, day, learnTime) values(?,?,?,?,?)";
    private final String DELETE_QUERY = "DELETE FROM time_log WHERE userId=?";

    @Override
    public void saveTimeLog(TimeLog timeLog) {
        jdbcOperations.update(SAVE_QUERY, timeLog.getUserId(),
                timeLog.getYear(), timeLog.getMonth(), timeLog.getDay(), timeLog.getLearnTimeThisDay());
    }

    @Override
    public List<TimeLog> fetchTimeLog(long userId) {
        List<TimeLog> list = new ArrayList<>();
        return jdbcOperations.queryForObject(FETCH_QUERY, (rs, rowNum) -> {
            do {
                TimeLog timeLog = new TimeLog();
                timeLog.setUserId(userId);
                timeLog.setYear(rs.getInt("year"));
                timeLog.setMonth(rs.getInt("month"));
                timeLog.setDay(rs.getInt("day"));
                timeLog.setLearnTimeThisDay(rs.getLong("learnTime"));
                list.add(timeLog);
            } while (rs.next());
            return list;
        }, userId);
    }

    @Override
    public List<TimeLog> fetchOneByLocalDate(long userId, LocalDate localDate) {
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();

        List<TimeLog> logList = new ArrayList<>();
        return jdbcOperations.queryForObject(FETCH_QUERY_DATE, (rs, rowNum) -> {
            do {
                TimeLog timeLog = new TimeLog();
                timeLog.setUserId(rs.getLong("userId"));
                timeLog.setYear(rs.getInt("year"));
                timeLog.setMonth(rs.getInt("month"));
                timeLog.setDay(rs.getInt("day"));
                timeLog.setLearnTimeThisDay(rs.getLong("learnTime"));
                logList.add(timeLog);
            } while (rs.next());
            return logList;
        }, userId, year, month, day);
    }

    @Override
    public void deleteLogList(long userId) {
        jdbcOperations.update(DELETE_QUERY, userId);
    }
}
