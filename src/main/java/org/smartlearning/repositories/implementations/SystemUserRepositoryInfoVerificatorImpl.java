package org.smartlearning.repositories.implementations;

import org.smartlearning.repositories.interfaces.SystemUserRepositoryInfoVerificator;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class SystemUserRepositoryInfoVerificatorImpl implements SystemUserRepositoryInfoVerificator {
    private JdbcOperations jdbcOperations;
    private final String SEARCH_BY_USERNAME = "SELECT username FROM SystemUser WHERE username=?";
    private final String SEARCH_BY_EMAIL = "SELECT email FROM SystemUser WHERE email=?";


    public SystemUserRepositoryInfoVerificatorImpl(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public boolean isUserNameExistInDatabase(String username) {
        try {
            jdbcOperations.queryForObject(SEARCH_BY_USERNAME, new UserNameMapper(), username);
        } catch (EmptyResultDataAccessException exception) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmailExistInDatabase(String email) {
        try {
            jdbcOperations.queryForObject(SEARCH_BY_EMAIL, new EmailMapper(), email);
        } catch (EmptyResultDataAccessException exception) {
            return true;
        }
        return false;
    }

    private final static class UserNameMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return resultSet.getString("username");
        }
    }

    private final static class EmailMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return resultSet.getString("email");
        }
    }
}
