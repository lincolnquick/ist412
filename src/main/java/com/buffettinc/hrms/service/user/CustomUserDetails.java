package com.buffettinc.hrms.service.user;

import com.buffettinc.hrms.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private User user;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(User user){

        this.user = user;
        this.authorities = Collections.singletonList(new SimpleGrantedAuthority("" + user.getRole()));
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    public User getUser() { return this.user; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getEmployeeID(){
        return this.user.getEmployee().getEmployeeID();
    }

    public String getFullName() {
        return user.getEmployee().getFirstName() + " " + user.getEmployee().getLastName();
    }
}
