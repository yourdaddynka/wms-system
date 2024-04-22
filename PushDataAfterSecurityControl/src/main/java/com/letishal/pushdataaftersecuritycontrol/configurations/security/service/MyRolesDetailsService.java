package com.letishal.pushdataaftersecuritycontrol.configurations.security.service;

import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.Client;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.model.ClientDetails;
import com.letishal.pushdataaftersecuritycontrol.configurations.security.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyRolesDetailsService implements UserDetailsService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = clientRepository.findByUserNickName(username);
        return client.map(ClientDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
