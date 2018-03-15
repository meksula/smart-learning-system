package org.smartlearning.core.user.extenders;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Karol Meksuła
 * 12-03-2018
 **/

public class SystemUserMetaDataTest {
    private SystemUserMetaData systemUserMetaData = new SystemUserMetaData();
    private final String links = "https://stackoverflow.com/ https://mvnrepository.com/ http://www.gazetaprawna.pl/";
    private Logger logger = LogManager.getLogger(SystemUserMetaData.class);

    @Before
    public void setUp() {
        systemUserMetaData.setLinks(links);
    }

    @Test
    public void testIfSplitStringWorksCorrectly() {
        List<String> list = systemUserMetaData.splitLinks();
        assertEquals(3, list.size());

        logger.info(list.get(0));
    }

}