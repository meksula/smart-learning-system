package org.smartlearning.repositories.interfaces;

public interface QuoteRepository {
    String fetchQuoteByDay(int dayNumber);

    void saveNewQuote();
}
