package org.smartlearning.core.content;

import org.smartlearning.repositories.interfaces.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Author Karol Meksuła
 * 10-03-2018
 **/

@Component
public class Quote {
    private static QuoteRepository quoteRepository;

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public static String quoteByDay() {
        int dayNumber = LocalDate.now().getDayOfMonth();
        return quoteRepository.fetchQuoteByDay(dayNumber);
    }
}
