package org.smartlearning.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.smartlearning.controller.ProfileController;
import org.smartlearning.domain.content.text.QuoteFormatter;
import org.smartlearning.domain.dto.Quote;
import org.smartlearning.repositories.interfaces.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Author Karol Meksuła
 * 21-03-2018
 **/

@Aspect
@Component
public class ProfileControllerAspect {
    private ProfileController profileController;
    private QuoteRepository quoteRepository;

    @Autowired
    public void setQuoteRepository(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    @Autowired
    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;
    }

    private long assignQuoteId() {
        return LocalDate.now().getDayOfMonth();
    }

    @Before("execution(* org.smartlearning.controller.ProfileController.mainProfile(..))")
    public void loadQuote() {
        Quote quote = quoteRepository.fetchQuoteByDay(assignQuoteId());
        QuoteFormatter formatter = QuoteFormatter.getInstance();
        formatter.formatQuote(quote);
        profileController.setQuote(quote);
    }
}
