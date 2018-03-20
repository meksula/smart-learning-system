package org.smartlearning.repositories.implementations;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartlearning.configuration.RootConfig;
import org.smartlearning.domain.user.extenders.SystemUserMetaData;
import org.smartlearning.repositories.interfaces.SystemUserMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 09-03-2018
 **/

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class SystemUserMetaDataRepositoryImplTest {
    private final long USER_ID = 8736224;
    private final String ABOUT_ME = "Some text about user...";

    @Autowired
    private SystemUserMetaDataRepository repository;

    private SystemUserMetaData createMetaData() {
        SystemUserMetaData systemUserMetaData = new SystemUserMetaData();
        systemUserMetaData.setUserId(USER_ID);
        systemUserMetaData.setAboutMe(ABOUT_ME);
        return systemUserMetaData;
    }

    @Test
    public void shouldSaveCorrectlyMetaData() {
        repository.saveMetaData(createMetaData());
        SystemUserMetaData meta = repository.fetchMetaData(USER_ID);
        assertEquals(ABOUT_ME, meta.getAboutMe());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void shouldRemoveCorrectly() {
        repository.deleteMetaData(USER_ID);
        repository.fetchMetaData(USER_ID);
    }

    @After
    public void cleanUp() {
        repository.deleteMetaData(USER_ID);
    }

}