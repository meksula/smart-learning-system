package org.smartlearning.core.security;

import org.smartlearning.core.user.SystemUser;
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

    public String encodeInsecurePassword(SystemUser systemUser) {
        String uncodedPassword = systemUser.getPassword();
        return passwordEncoder.encode(uncodedPassword);
    }
}
