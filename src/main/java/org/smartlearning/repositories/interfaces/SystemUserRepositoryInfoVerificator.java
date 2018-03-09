package org.smartlearning.repositories.interfaces;

/**
 * @Author Karol Meksuła
 * 09-03-2018
 **/

public interface SystemUserRepositoryInfoVerificator {
    boolean isUserNameExistInDatabase(String username);

    boolean isEmailExistInDatabase(String email);
}
