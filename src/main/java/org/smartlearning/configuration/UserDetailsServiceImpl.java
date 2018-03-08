package org.smartlearning.configuration;

import org.smartlearning.core.user.SystemUser;
import org.smartlearning.repositories.interfaces.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Karol Meksuła
 * 27-02-2018
 **/

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private SystemUserRepository systemUserRepository;

    @Autowired
    public void setRepository(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = systemUserRepository.fetchByUsername(username);
        if (systemUser != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new User(systemUser.getUsername(), systemUser.getPassword(), authorities);
        }
        throw new UsernameNotFoundException("Nie znaleziono użytkownika '" + username + "'.");
    }
}