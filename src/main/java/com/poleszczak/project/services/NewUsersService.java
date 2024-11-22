package com.poleszczak.project.services;

import com.poleszczak.project.models.NewUsers;
import com.poleszczak.project.repositories.NewUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class NewUsersService implements UserDetailsService {

    @Autowired
    private NewUsersRepository repo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        NewUsers newUsers = repo.findByEmail(email);

        if (newUsers != null){
            var springUser = User.withUsername(newUsers.getEmail())
                    .password(newUsers.getPassword())
                    .roles(newUsers.getRole())
                    .build();

            return springUser;

        }

        return null;
    }
}
