package org.smartlearning.repositories.interfaces;

public interface SystemUserRepositoryInfoVerificator {
    boolean isUserNameExistInDatabase(String username);

    boolean isEmailExistInDatabase(String email);
}
