package com.github.msidd.demo.service;

import com.github.msidd.demo.domain.User;
import com.github.msidd.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by msidd on 11/20/2015.
 */

@Component("mongoUserService")
public class MongoUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = this.repository.findByUserName(name);
        //construct a spring security specific user without any authorities
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), AuthorityUtils.createAuthorityList());
    }
}
