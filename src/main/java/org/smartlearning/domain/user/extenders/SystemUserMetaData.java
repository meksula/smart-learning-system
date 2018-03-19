package org.smartlearning.domain.user.extenders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Karol Meksuła
 * 01-03-2018
 **/

public class SystemUserMetaData {
    private long userId;
    private String avatarPath = "/resources/css/avatar.jpg";
    private String aboutMe;
    private String links;

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

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public List<String> splitLinks() {
        String [] array = links.split(" ");
        List<String> linksList = new ArrayList<>();
        linksList = Arrays.asList(array);
        return linksList;
    }
}
