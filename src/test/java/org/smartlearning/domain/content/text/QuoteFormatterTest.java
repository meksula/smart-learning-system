package org.smartlearning.domain.content.text;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.smartlearning.domain.dto.Quote;

import static junit.framework.TestCase.assertEquals;

/**
 * @Author Karol Meksuła
 * 21-03-2018
 **/

public class QuoteFormatterTest {
    private final Logger logger = LogManager.getLogger(QuoteFormatterTest.class);
    private QuoteFormatter quoteFormatter = QuoteFormatter.getInstance();
    private final String QUOTE = "Per Aspera, ad astra. Romanian sentence";
    private Quote quote;

    @Before
    public void setUp() {
        quote = new Quote();
        quote.setText(QUOTE);
    }

    @Test
    public void formaterShouldAddBrTag() {
        String formatted = quoteFormatter.formatQuote(quote);
        logger.info(formatted);

        assertEquals("Per Aspera, ad astra<br/> Romanian sentence", formatted);
    }
}