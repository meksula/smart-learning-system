package org.smartlearning.repositories.implementations;

import org.smartlearning.domain.user.extenders.SystemUserStatistics;
import org.smartlearning.repositories.interfaces.SystemUserStatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author Karol Meksuła
 * 08-03-2018
 **/

@Repository
public class SystemUserStatsRepositoryImpl implements SystemUserStatsRepository {
    private final String FETCH_QUERY = "SELECT * FROM stats WHERE userId=?";
    private final String SAVE_QUERY = "INSERT INTO stats " +
            "(userId, allSessions, allDays, tasksDone, tasksNotDoneYet, bestDay, worstDay, totalLearningTimeInMinutes, favouriteBranchOfScience) " +
            "VALUES(?,?,?,?,?,?,?,?,?)";
    private final String UPDATE_QUERY = "UPDATE stats " +
            "SET allSessions=?, allDays=?, tasksDone=?, tasksNotDoneYet=?, bestDay=?, worstDay=?, totalLearningTimeInMinutes=?, favouriteBranchOfScience=? WHERE userId=?";
    private final String DELETE_QUERY = "DELETE FROM stats WHERE userId=?";
    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void saveStatistics(SystemUserStatistics systemUserStatistics) {
        jdbcOperations.update(SAVE_QUERY,
                systemUserStatistics.getUserId(), systemUserStatistics.getAllSessions(),
                systemUserStatistics.getAllDays(), systemUserStatistics.getTasksDone(),
                systemUserStatistics.getTasksNotDoneYet(), systemUserStatistics.getBestDay(),
                systemUserStatistics.getWorstDay(), systemUserStatistics.getTotalLearningTimeInMinutes(),
                systemUserStatistics.getFavouriteBranchOfScience());
    }

    /*UPDATE table_name
    SET column1 = value1, column2 = value2, ...
    WHERE condition;*/

    @Override
    public void updateStatistics(SystemUserStatistics systemUserStatistics) {
        jdbcOperations.update(UPDATE_QUERY,
                systemUserStatistics.getAllSessions(),
                systemUserStatistics.getAllDays(), systemUserStatistics.getTasksDone(),
                systemUserStatistics.getTasksNotDoneYet(), systemUserStatistics.getBestDay(),
                systemUserStatistics.getWorstDay(), systemUserStatistics.getTotalLearningTimeInMinutes(),
                systemUserStatistics.getFavouriteBranchOfScience(), systemUserStatistics.getUserId());
    }

    @Override
    public SystemUserStatistics fetchStatistics(long userId) {
        SystemUserStatistics systemUserStatistics = new SystemUserStatistics();
        jdbcOperations.queryForObject(FETCH_QUERY, new RowMapper<SystemUserStatistics>() {
            @Override
            public SystemUserStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
                systemUserStatistics.setUserId(rs.getLong(1));
                systemUserStatistics.setAllSessions(rs.getInt(2));
                systemUserStatistics.setAllDays(rs.getInt(3));
                systemUserStatistics.setTasksDone(rs.getInt(4));
                systemUserStatistics.setTasksNotDoneYet(rs.getInt(5));
                systemUserStatistics.setBestDay(rs.getString(6));
                systemUserStatistics.setWorstDay(rs.getString(7));
                systemUserStatistics.setTotalLearningTimeInMinutes(rs.getInt(8));
                systemUserStatistics.setFavouriteBranchOfScience(rs.getString(9));
                return systemUserStatistics;
            }
        }, userId);
        return systemUserStatistics;
    }

    @Override
    public void deleteSystemUserStats(long userId) {
        jdbcOperations.update(DELETE_QUERY, userId);
    }

}
