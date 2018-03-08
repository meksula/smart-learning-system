package org.smartlearning.core.user;

import org.smartlearning.core.content.Notes;
import org.smartlearning.core.content.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

public class SystemUser {
    private long userId;
    private String username;
    private String name;
    private String surname;
    private int bornYear;
    private String email;
    private String password;

    private Statistics statistics;
    private SystemUserMetaData systemUserMetaData;
    private ArrayList<Notes> listOfNotes;
    private ArrayList<Task> listOfTasksToDo;
    private ArrayList<Task> listOfDoneTasks;

    public Map<String, String> getUsernameAndUserId() {
        Map<String, String> nicknameAndUserId = new HashMap<>();
        nicknameAndUserId.put("username", this.username);
        nicknameAndUserId.put("userId", String.valueOf(this.userId));
        return nicknameAndUserId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public ArrayList<Notes> getListOfNotes() {
        return listOfNotes;
    }

    public void setListOfNotes(ArrayList<Notes> listOfNotes) {
        this.listOfNotes = listOfNotes;
    }

    public ArrayList<Task> getListOfTasksToDo() {
        return listOfTasksToDo;
    }

    public void setListOfTasksToDo(ArrayList<Task> listOfTasksToDo) {
        this.listOfTasksToDo = listOfTasksToDo;
    }

    public ArrayList<Task> getListOfDoneTasks() {
        return listOfDoneTasks;
    }

    public void setListOfDoneTasks(ArrayList<Task> listOfDoneTasks) {
        this.listOfDoneTasks = listOfDoneTasks;
    }

    public SystemUserMetaData getSystemUserMetaData() {
        return systemUserMetaData;
    }

    public void setSystemUserMetaData(SystemUserMetaData systemUserMetaData) {
        this.systemUserMetaData = systemUserMetaData;
    }
}
