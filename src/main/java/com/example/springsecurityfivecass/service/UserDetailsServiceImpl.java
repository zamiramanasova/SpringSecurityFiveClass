package com.example.springsecurityfivecass.service;

import com.example.springsecurityfivecass.entity.securemodel.MyUser;
import com.example.springsecurityfivecass.entity.securemodel.User;
import com.example.springsecurityfivecass.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.getUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("could not find user");
        }
        return new MyUser(user);
    }
}
