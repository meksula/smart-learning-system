package org.smartlearning.repositories.interfaces;

import org.smartlearning.domain.dto.Quote;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */

public interface QuoteRepository {
    Quote fetchQuoteByDay(long id);

    void saveNewQuote(Quote quote);

    void deleteQuote(long id);

    long countQuotes();
}
