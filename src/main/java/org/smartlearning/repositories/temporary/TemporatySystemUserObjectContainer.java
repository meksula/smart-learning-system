package org.smartlearning.repositories.temporary;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.smartlearning.domain.user.SystemUser;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Deprecated
//@Component
public class TemporatySystemUserObjectContainer {
    private Map<String, SystemUser> systemUserMap;
    private static final Logger LOGGER = LogManager.getLogger(TemporatySystemUserObjectContainer.class);

    public TemporatySystemUserObjectContainer() {
        systemUserMap = new HashMap<>();
    }

    public void putSystemUserToMap(SystemUser systemUser) {
        LOGGER.info("UserName " + systemUser.getUsername() + " just put to TemporarySystemUserObjectContainer.class");
        systemUserMap.put(systemUser.getUsername(), systemUser);
    }

    public SystemUser getSystemUserFromMap(String username) {
        LOGGER.info(username + " just get from TemporarySystemUserObjectContainer.class");
        return systemUserMap.get(username);
    }

    public void clearTemporaryMap() {
        systemUserMap.clear();
    }

    public Map<String, SystemUser> getSystemUserMap() {
        return systemUserMap;
    }
}
