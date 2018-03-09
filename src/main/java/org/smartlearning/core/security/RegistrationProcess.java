package org.smartlearning.core.security;

import org.smartlearning.core.user.SystemUser;
import org.smartlearning.core.user.SystemUserForm;
import org.smartlearning.repositories.interfaces.SystemUserRepository;
import org.smartlearning.repositories.interfaces.SystemUserRepositoryInfoVerificator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Karol Meksuła
 * 07-03-2018
 **/

@Service
public class RegistrationProcess {
    private SystemUserRepository systemUserRepository;
    private SystemUserRepositoryInfoVerificator systemUserRepositoryInfoVerificator;
    private PasswordEncoderHelperClass passwordEncoderHelperClass;
    private SystemUserForm systemUserForm;

    @Autowired
    public void setSystemUserRepository(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Autowired
    public void setSystemUserRepositoryHelper(SystemUserRepositoryInfoVerificator systemUserRepositoryHInfoVerificator) {
        this.systemUserRepositoryInfoVerificator = systemUserRepositoryHInfoVerificator;
    }

    @Autowired
    public void setPasswordEncoderHelperClass(PasswordEncoderHelperClass passwordEncoderHelperClass) {
        this.passwordEncoderHelperClass = passwordEncoderHelperClass;
    }

    public boolean verify(SystemUserForm systemUserForm) {
        this.systemUserForm = systemUserForm;

        boolean emailVerificated = checkIfEmailIsNotUsed();
        boolean userNameVerificated = checkIfUserNameIsNotUsed();
        boolean passwordIsMatches = checkIfPasswordIsMatches();

        if (emailVerificated && userNameVerificated && passwordIsMatches) {
            saveSystemUser();
            return true;
        }

        else return false;
    }

    private boolean checkIfUserNameIsNotUsed() {
        return systemUserRepositoryInfoVerificator.isUserNameExistInDatabase(systemUserForm.getUsername());
    }

    private boolean checkIfEmailIsNotUsed() {
        return systemUserRepositoryInfoVerificator.isEmailExistInDatabase(systemUserForm.getEmail());
    }

    private boolean checkIfPasswordIsMatches() {
        return systemUserForm.getPassword().equals(systemUserForm.getConfirmPassword());
    }

    private void saveSystemUser() {
        SystemUser systemUserWaitingToSave = convertFormToSystemUser();
        systemUserRepository.saveSystemUser(systemUserWaitingToSave);
    }

    private SystemUser convertFormToSystemUser() {
        SystemUser systemUser = new SystemUser();
        String password = passwordEncoderHelperClass.encodeInsecurePassword(systemUserForm);
        systemUser.setUsername(systemUserForm.getUsername());
        systemUser.setName(systemUserForm.getName());
        systemUser.setSurname(systemUserForm.getSurname());
        systemUser.setBornYear(systemUserForm.getBornYear());
        systemUser.setEmail(systemUserForm.getEmail());
        systemUser.setPassword(password);
        return systemUser;
    }

}