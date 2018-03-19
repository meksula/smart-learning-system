package org.smartlearning.domain.security;

import org.smartlearning.domain.user.extenders.SystemUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderHelperClass {
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String encodeInsecurePassword(SystemUserForm systemUserForm) {
        String uncodedPassword = systemUserForm.getPassword();
        return passwordEncoder.encode(uncodedPassword);
    }
}
