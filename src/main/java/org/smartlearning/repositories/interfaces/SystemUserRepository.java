package org.smartlearning.repositories.interfaces;

import org.smartlearning.core.user.SystemUser;

public interface SystemUserRepository {
    SystemUser fetchByUsername(String username);

    void saveSystemUser(SystemUser systemUser);

}
