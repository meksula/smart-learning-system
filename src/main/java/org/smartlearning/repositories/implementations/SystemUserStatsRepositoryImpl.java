package org.smartlearning.repositories.implementations;

import org.smartlearning.core.user.extenders.SystemUserStatistics;
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
    private final String UPDATE_QUERY = ""; //TODO
    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void saveStatistics(SystemUserStatistics systemUserStatistics) {

    }

    @Override
    public void updateStatistics(SystemUserStatistics systemUserStatistics) {

    }

    @Override
    public SystemUserStatistics fetchStatistics(long userId) {
        SystemUserStatistics systemUserStatistics = new SystemUserStatistics();
        jdbcOperations.queryForObject(FETCH_QUERY, new RowMapper<SystemUserStatistics>() {
            @Override
            public SystemUserStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
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
        });
        return systemUserStatistics;
    }

}
