package org.smartlearning.repositories.implementations;

import org.smartlearning.domain.services.Quote;
import org.smartlearning.repositories.interfaces.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */

@Repository
public class QuoteRepositoryImpl implements QuoteRepository {
    private final String FETCH_QUERY = "SELECT * FROM Quote WHERE id=?";
    private final String SAVE_QUERY = "INSERT INTO Quote (quote) values(?)";
    private JdbcOperations jdbcOperations;

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public Quote fetchQuoteByDay(long id) {
        Quote quote = new Quote();
        jdbcOperations.queryForObject(FETCH_QUERY,
                (rs, rowNum) -> {
                    //quote = rs.getString("quote");
                    quote.setId(rs.getLong("id"));
                    quote.setText(rs.getString("quote"));
                    return quote;
                }, id);
        return quote;
    }

    @Override
    public void saveNewQuote(String quoteText) {
        jdbcOperations.update(SAVE_QUERY, quoteText);
    }
}
