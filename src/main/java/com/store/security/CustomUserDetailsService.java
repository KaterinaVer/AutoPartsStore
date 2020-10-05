package com.store.security;

import com.store.entity.User;
import com.store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
        final User userEntity = userService.findByLogin(userName);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
