package org.smartlearning.repositories.implementations;

import org.smartlearning.domain.dto.Quote;
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
    private final String SAVE_QUERY = "INSERT INTO Quote (id, quote) values(?, ?)";
    private final String DELETE_QUERY = "DELETE FROM Quote WHERE id=?";
    private final String COUNT_ENTITIES = "SELECT * FROM Quote";
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
                    quote.setId(rs.getLong("id"));
                    quote.setText(rs.getString("quote"));
                    return quote;
                }, id);
        return quote;
    }

    @Override
    public void saveNewQuote(Quote quote) {
        jdbcOperations.update(SAVE_QUERY, quote.getId(), quote.getText());
    }

    @Override
    public void deleteQuote(long id) {
        jdbcOperations.update(DELETE_QUERY, id);
    }

    @Override
    public long countQuotes() {
        final long[] count = {0};
        return jdbcOperations.queryForObject(COUNT_ENTITIES,
                (rs, rowNum) -> {
                    do {
                        count[0]++;
                    } while (rs.next());

                    return count[0];
                });
    }
}
