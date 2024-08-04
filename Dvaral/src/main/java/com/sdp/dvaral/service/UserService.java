package com.sdp.dvaral.service;

import com.sdp.dvaral.model.Users;
import com.sdp.dvaral.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users addUser(Users user) {

        return userRepository.save(user);

    }

    public List<Users> getAllUsers() {

        return userRepository.findAll();
    }

    public Users getUser(Long userID) {
        return userRepository.findById(userID).get();
    }
}
