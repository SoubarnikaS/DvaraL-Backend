package com.sdp.dvaral.controller;

import com.sdp.dvaral.model.Users;
import com.sdp.dvaral.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> addUser(@RequestBody Users user) {

        try{
            Users isAdded = userService.addUser(user);

            if (isAdded != null) {
                return new  ResponseEntity<>("User added successfully with user ID: " + user.getUserID(), HttpStatus.CREATED);
            }
            return new ResponseEntity<>("User not added", HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/fetch/allUser")
    public ResponseEntity<?> getAllUsers() {

        try{
            List<Users> usersList = userService.getAllUsers();

            if (!usersList.isEmpty()) {
                return new ResponseEntity<>(usersList, HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
