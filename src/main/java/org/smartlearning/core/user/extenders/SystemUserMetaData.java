package org.smartlearning.core.user.extenders;

/**
 * @Author Karol Meksuła
 * 01-03-2018
 **/

public class SystemUserMetaData {
    private long userId;
    private String avatarPath = "/resources/css/avatar.jpg";
    private String aboutMe;

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
