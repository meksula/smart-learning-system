package org.smartlearning.repositories.implementations;

import org.smartlearning.domain.user.extenders.SystemUserMetaData;
import org.smartlearning.repositories.interfaces.SystemUserMetaDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 * @Author Karol Meksuła
 * 09-03-2018
 **/

@Repository
public class SystemUserMetaDataRepositoryImpl implements SystemUserMetaDataRepository {
    private JdbcOperations jdbcOperations;
    private final String SAVE_QUERY = "INSERT INTO metadata (userId, avatarPath, aboutMe) VALUES(?,?,?)";
    private final String FETCH_QUERY = "SELECT * FROM metadata WHERE userId=?";

    @Autowired
    public void setJdbcOperations(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void saveMetaData(SystemUserMetaData systemUserMetaData) {
        jdbcOperations.update(SAVE_QUERY,
                systemUserMetaData.getUserId(),
                systemUserMetaData.getAvatarPath(),
                systemUserMetaData.getAboutMe());
    }

    @Override
    public SystemUserMetaData fetchMetaData(long userId) {
        SystemUserMetaData systemUserMetaData = new SystemUserMetaData();
        jdbcOperations.queryForObject(FETCH_QUERY, (rs, rowNum) -> {
            systemUserMetaData.setUserId(rs.getInt(2));
            systemUserMetaData.setAvatarPath(rs.getString(3));
            systemUserMetaData.setAboutMe(rs.getString(4));
            systemUserMetaData.setLinks(rs.getString(5));
            return systemUserMetaData;
        }, userId);

        return systemUserMetaData;
    }

}
