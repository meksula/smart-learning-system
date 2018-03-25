package org.smartlearning.domain.content.text;

import org.smartlearning.domain.dto.Quote;

/**
 * @Author Karol Meksuła
 * 21-03-2018
 **/

public class QuoteFormatter {
    private static QuoteFormatter ourInstance = new QuoteFormatter();

    public static QuoteFormatter getInstance() {
        return ourInstance;
    }

    private QuoteFormatter() {
    }

    public String formatQuote(Quote quote) {
        StringBuilder builder = new StringBuilder();
        String txt = quote.getText();
        String [] tab = txt.split("\\.");
        builder.append(tab[0]).append("<br/>").append(tab[1]);
        return builder.toString();
    }
}
