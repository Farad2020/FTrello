package com.faraby_lab.task3.restapivue.services.impl;

import com.faraby_lab.task3.restapivue.entities.Users;
import com.faraby_lab.task3.restapivue.repo.UserRepo;
import com.faraby_lab.task3.restapivue.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userRepo.findByEmail(s);
        if( user != null )
            return user;
        else
            throw new UsernameNotFoundException("USER NOT FOUND");
    }
    //I STOPPED AT 33:52
}
