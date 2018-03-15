package org.smartlearning.core.content.websites;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.core.user.extenders.SystemUserMetaData;
import org.smartlearning.repositories.interfaces.SystemUserMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class ArticleFetcherTest {
    private SystemUserMetaData systemUserMetaData;
    private final Logger logger = LogManager.getLogger(ArticleFetcherTest.class);

    @Autowired
    private ArticleFetcher articleFetcher;

    @Autowired
    private SystemUserMetaDataRepository repository;

    @Test
    public void setUp() {
        systemUserMetaData = repository.fetchMetaData(1);
    }

    @Test
    public void shouldGetHtmlDocFromLink() throws IOException {
        articleFetcher.fetchAndParse(systemUserMetaData);
        String html = articleFetcher.giveMeOneArticle();
        logger.info(html);
    }

}