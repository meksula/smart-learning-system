package org.smartlearning.domain.content;

import org.smartlearning.repositories.interfaces.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Author Karol Meksuła
 * 10-03-2018
 **/

//TODO to będzie przeniesione do aspektu
/*@Component
public class Quote {
    private QuoteRepository quoteRepository;

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public String quoteByDay() {
        int dayNumber = LocalDate.now().getDayOfMonth();
        return quoteRepository.fetchQuoteByDay(dayNumber);
    }
}*/
