package org.smartlearning.repositories.implementations;

import org.smartlearning.domain.user.SystemUser;
import org.smartlearning.repositories.interfaces.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */

@Repository
public class SystemUserRepositoryImpl implements SystemUserRepository {
    private final String FETCH_QUERY = "SELECT * FROM SystemUser WHERE username=?";
    private final String SAVE_QUERY = "INSERT INTO SystemUser (username, name, surname, bornYear, email, password) values(?,?,?,?,?,?)";
    private final String DELETE_QUERY = "DELETE FROM SystemUser WHERE id=?";
    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public SystemUser fetchByUsername(String username) {
        return jdbcOperations.queryForObject(FETCH_QUERY, new SystemUserMapper(), username);
    }

    private final class SystemUserMapper implements RowMapper<SystemUser> {
        @Override
        public SystemUser mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            SystemUser systemUser = new SystemUser();
            systemUser.setUserId(resultSet.getLong(1));
            systemUser.setUsername(resultSet.getString(2));
            systemUser.setName(resultSet.getString(3));
            systemUser.setSurname(resultSet.getString(4));
            systemUser.setBornYear(resultSet.getInt(5));
            systemUser.setEmail(resultSet.getString(6));
            systemUser.setPassword(resultSet.getString(7));
            return systemUser;
        }
    }

    @Override
    public void saveSystemUser(SystemUser systemUser) {
        jdbcOperations.update(SAVE_QUERY,
                systemUser.getUsername(),
                systemUser.getName(),
                systemUser.getSurname(),
                systemUser.getBornYear(),
                systemUser.getEmail(),
                systemUser.getPassword());
    }

    @Override
    public void deleteSystemUser(long userId) {
        jdbcOperations.update(DELETE_QUERY, userId);
    }

}
