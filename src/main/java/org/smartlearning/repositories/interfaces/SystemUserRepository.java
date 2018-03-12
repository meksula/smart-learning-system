package org.smartlearning.repositories.interfaces;

import org.smartlearning.core.user.SystemUser;

/**
 * @Author Karol Meksuła
 * 09-03-2018
 **/

public interface SystemUserRepository {
    SystemUser fetchByUsername(String username);

    void saveSystemUser(SystemUser systemUser);

    void deleteSystemUser(long userId);
}
