package org.smartlearning.repositories.implementations;

import org.smartlearning.repositories.interfaces.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class QuoteRepositoryImpl implements QuoteRepository {
    private final String FETCH_QUERY = "SELECT * FROM quotes WHERE dayNumber=?";
    private final String SAVE_QUERY = "INSERT INTO quotes (dayNumber, quote) values(?,?)";
    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private String quote;

    @Override
    public String fetchQuoteByDay(int dayNumber) {
        jdbcOperations.queryForObject(FETCH_QUERY,
                (rs, rowNum) -> {
                    quote = rs.getString("quote");
                    return quote;
                }, dayNumber);
        return quote;
    }

    @Override
    public void saveNewQuote() {
        //TODO
    }
}
