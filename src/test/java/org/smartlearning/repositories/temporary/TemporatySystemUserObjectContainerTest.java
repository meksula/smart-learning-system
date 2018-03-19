package org.smartlearning.repositories.temporary;

import org.junit.Before;
import org.junit.Test;
import org.smartlearning.domain.user.SystemUser;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 09-03-2018
 **/

public class TemporatySystemUserObjectContainerTest {
    private TemporatySystemUserObjectContainer temporatySystemUserObjectContainer;
    private SystemUser systemUser;
    private final String NAME = "Karol";

    @Before
    public void setUp() {
        temporatySystemUserObjectContainer = new TemporatySystemUserObjectContainer();
        systemUser = new SystemUser();
        systemUser.setUsername(NAME);
    }

    @Test
    public void sutShouldBeAbleToPutObject() {
        temporatySystemUserObjectContainer.putSystemUserToMap(systemUser);
        assertTrue(temporatySystemUserObjectContainer.getSystemUserMap().size() == 1);
    }

    @Test
    public void sutShouldBeAbleToGetObject() {
        temporatySystemUserObjectContainer.putSystemUserToMap(systemUser);
        SystemUser systemUser = temporatySystemUserObjectContainer.getSystemUserFromMap(NAME);
        assertEquals(NAME, systemUser.getUsername());
    }

    @Test
    public void sutShouldBeAbleToClearItself() {
        temporatySystemUserObjectContainer.putSystemUserToMap(systemUser);
        temporatySystemUserObjectContainer.clearTemporaryMap();
        assertTrue(temporatySystemUserObjectContainer.getSystemUserMap().isEmpty());
    }
}