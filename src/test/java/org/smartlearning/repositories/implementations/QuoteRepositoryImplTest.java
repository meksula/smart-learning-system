package org.smartlearning.repositories.implementations;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.services.Quote;
import org.smartlearning.repositories.interfaces.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author
 * Karol Meksuła
 * 27-02-2018
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class QuoteRepositoryImplTest {
    private final String TEXT = "Per aspera ad astra";

    @Autowired
    private QuoteRepository quoteRepository;

    private Quote createQuote() {
        Quote quote = new Quote();
        quote.setText(TEXT);
        return quote;
    }

    private long count;

    @Test
    public void quoteShouldBeAbleToSaveAndFetchSame() {
        count = quoteRepository.countQuotes();
        quoteRepository.saveNewQuote(createQuote());
        Quote quote = quoteRepository.fetchQuoteByDay(count);
        assertEquals(TEXT, quote.getText());
    }

    @After
    public void cleanUp() {
        quoteRepository.deleteQuote(count);
    }
}