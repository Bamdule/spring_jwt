package com.bamdule.auth;

import com.bamdule.model.UserVO;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author kim
 */
public class UserDetailsVO implements UserDetails {

    private UserVO userVO;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsVO() {
    }

    public UserDetailsVO(UserVO userVO, Collection<? extends GrantedAuthority> authorities) {
        this.userVO = userVO;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return userVO.getPassword();
    }

    @Override
    public String getUsername() {
        return userVO.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userVO.getIsEnable();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userVO.getIsEnable();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userVO.getIsEnable();
    }

    @Override
    public boolean isEnabled() {
        return userVO.getIsEnable();
    }

    public UserVO getUserVO() {
        return userVO;
    }

}
