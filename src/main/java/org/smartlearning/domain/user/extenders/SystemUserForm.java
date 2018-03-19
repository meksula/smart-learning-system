package org.smartlearning.domain.user.extenders;

import javax.validation.constraints.*;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

public class SystemUserForm {
    @NotNull
    private long userId;

    @NotNull
    @Size(min=6, max=15)
    private String username;

    @NotNull
    @Size(min=5, max=25)
    private String password;

    @NotNull
    @Size(min = 5, max = 25)
    private String confirmPassword;

    @NotNull
    @Size(min=2, max=15)
    private String name;

    @NotNull
    @Size(min=2, max=15)
    private String surname;

    @Min(1930)
    @Max(2015)
    private int bornYear;

    @Email
    private String email;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
}
