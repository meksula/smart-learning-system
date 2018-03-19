package org.smartlearning.repositories.interfaces;

import org.smartlearning.core.services.Quote;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */

public interface QuoteRepository {
    Quote fetchQuoteByDay(long id);

    void saveNewQuote(String quoteText);
}
