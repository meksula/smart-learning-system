package org.smartlearning.core.user;

/**
 * @Author Karol Meksuła
 * 01-03-2018
 **/

public class SystemUserMetaData {
    private String avatarPath = "/resources/images/avatar.jpg";
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
}
