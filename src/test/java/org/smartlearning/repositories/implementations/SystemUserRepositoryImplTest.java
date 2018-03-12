package org.smartlearning.repositories.implementations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.core.user.SystemUser;
import org.smartlearning.repositories.interfaces.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class SystemUserRepositoryImplTest {
    private final String USERNAME = "admin";
    private final String USERNAME2 = "picasso";
    private SystemUser systemUser;

    private void setUpSystemUser() {
        systemUser = new SystemUser();
        systemUser.setUsername(USERNAME2);
        systemUser.setName("Pablo");
        systemUser.setPassword("Picasso");
        systemUser.setEmail("picasso38.p@gmail.com");
    }

    @Autowired
    private SystemUserRepository systemUserRepository;

    private final Logger logger = LogManager.getLogger(SystemUserRepositoryImplTest.class);

    @Test
    public void checkIfNotNull() {
        assertNotNull(systemUserRepository);
    }

    @Test
    public void sutShouldFetchCorrectlySystemUser() {
        SystemUser systemUser = systemUserRepository.fetchByUsername(USERNAME);
        assertNotNull(systemUser);
        logger.info(systemUser.getEmail());
    }

    private long userId;

    @Test
    public void entityShouldBeCorrectlyWritten() {
        setUpSystemUser();
        systemUserRepository.saveSystemUser(systemUser);
        logger.info(systemUser.getUsername() + " just saved to database.");

        SystemUser systemUser = systemUserRepository.fetchByUsername(USERNAME2);
        assertNotNull(systemUser);
        assertEquals(systemUser.getUsername(), USERNAME2);
        userId = systemUser.getUserId();
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void sutShouldCanDeleteSystemUser() {
        logger.info("Removing entity where id = " + userId);

        SystemUser systemUser = systemUserRepository.fetchByUsername(USERNAME2);
        systemUserRepository.deleteSystemUser(systemUser.getUserId());

        SystemUser systemUserAfterDelete = systemUserRepository.fetchByUsername(USERNAME2);
        assertNull(systemUserAfterDelete);
    }
}