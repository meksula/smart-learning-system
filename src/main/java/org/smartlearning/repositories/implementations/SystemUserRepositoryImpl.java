package org.smartlearning.repositories.implementations;

import org.smartlearning.core.user.SystemUser;
import org.smartlearning.repositories.interfaces.SystemUserRepository;
import org.smartlearning.repositories.temporary.TemporatySystemUserObjectContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class SystemUserRepositoryImpl implements SystemUserRepository {
    private String FETCH_QUERY = "SELECT * FROM systemUsers WHERE username=?";
    private String SAVE_QUERY = "INSERT INTO systemUsers (username, name, surname, bornYear, email, password) values(?,?,?,?,?,?)";
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

}
