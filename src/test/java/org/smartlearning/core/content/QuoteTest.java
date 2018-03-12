package org.smartlearning.core.content;

import org.junit.Before;
import org.junit.Test;
import org.smartlearning.repositories.interfaces.QuoteRepository;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @Author Karol Meksuła
 * 10-03-2018
 **/

public class QuoteTest {
    private Quote quote;
    private QuoteRepository quoteRepository = mock(QuoteRepository.class);
    private static final String MOCK_QUOTE = "Per aspera ad astra.";
    private final int DAY = LocalDate.now().getDayOfMonth();

    @Before
    public void setUp() {
        quote = new Quote();
        quote.setQuoteRepository(quoteRepository);

        when(quoteRepository.fetchQuoteByDay(DAY)).thenReturn(MOCK_QUOTE);
    }

    @Test
    public void quoteShoutGiveStringByDayNumber() {
        assertEquals(MOCK_QUOTE, Quote.quoteByDay());
        verify(quoteRepository).fetchQuoteByDay(DAY);
    }
}