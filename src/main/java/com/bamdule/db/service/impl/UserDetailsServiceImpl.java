package com.bamdule.db.service.impl;

import com.bamdule.auth.UserDetailsVO;
import com.bamdule.exception.UserNotFoundException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.bamdule.db.service.UserService;

/**
 *
 * @author kim
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetailsVO loadUserByUsername(String userEmail) {
        return userService
                .selectByEmail(userEmail)
                .map(u -> new UserDetailsVO(u, Collections.singleton(new SimpleGrantedAuthority(u.getRole()))))
                .orElseThrow(() -> new UserNotFoundException(userEmail));
    }
}
