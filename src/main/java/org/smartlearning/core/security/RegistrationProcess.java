package org.smartlearning.core.security;

import org.smartlearning.core.user.SystemUserForm;
import org.springframework.stereotype.Service;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

@Service
public class RegistrationProcess {

    public boolean verifyIfUsernameIsNotUsed(SystemUserForm systemUserForm) {
        return true;
    }
}

//TODO tutaj będzie logika sprawdzająca czy użytkownik może się zarejestrować czy nie