package org.smartlearning.repositories.implementations;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.user.SystemUser;
import org.smartlearning.repositories.interfaces.SystemUserRepository;
import org.smartlearning.repositories.interfaces.SystemUserRepositoryInfoVerificator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 19-03-2018
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class SystemUserRepositoryInfoVerificatorImplTest {
    private final String USERNAME = "JuliuszCezar";
    private final String E_MAIL = "cezar_czarus@gmail.com";

    @Autowired
    private SystemUserRepositoryInfoVerificator verificator;

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Test
    public void checkIfSystemUserIsPersistInDatabase() {
        boolean flag = verificator.isUserNameExistInDatabase(USERNAME);
        assertTrue(flag);
    }

    @Test
    public void checkIfEmailIsRegisteredInSystem() {
        boolean flag = verificator.isEmailExistInDatabase(E_MAIL);
        assertTrue(flag);
    }

    private void insertUserToDatabase() {
        SystemUser systemUser = new SystemUser();
        systemUser.setUsername(USERNAME);
        systemUser.setEmail(E_MAIL);
        systemUserRepository.saveSystemUser(systemUser);
    }

    @Test
    public void nicknameShouldBeInDatabaseAndShouldReturnFalse() {
        insertUserToDatabase();
        boolean flag = verificator.isUserNameExistInDatabase(USERNAME);
        assertFalse(flag);
    }

    @Test
    public void emailShouldBeInDatabaseAndShouldReturnFalse() {
        insertUserToDatabase();
        boolean flag = verificator.isEmailExistInDatabase(E_MAIL);
        assertFalse(flag);
    }

    @After
    public void cleanUpDatabase() {
        systemUserRepository.deleteSystemUser(USERNAME);
    }

}