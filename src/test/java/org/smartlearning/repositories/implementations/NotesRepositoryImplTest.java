package org.smartlearning.repositories.implementations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.configuration.WebApplicationInitializer;
import org.smartlearning.configuration.WebApplicationServletConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebApplicationServletConfiguration.class, RootConfig.class})
public class NotesRepositoryImplTest {

    @Test
    public void test() {

    }
}