package org.smartlearning.repositories.interfaces;

import org.smartlearning.domain.user.extenders.SystemUserMetaData;

/**
 * @Author Karol Meksuła
 * 09-03-2018
 **/

public interface SystemUserMetaDataRepository {
    void saveMetaData(SystemUserMetaData systemUserMetaData);

    SystemUserMetaData fetchMetaData(long userId);

    void deleteMetaData(long userId);
}
