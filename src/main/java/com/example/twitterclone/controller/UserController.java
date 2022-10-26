package com.example.twitterclone.controller;

import com.example.twitterclone.doa.UserDoa;
import com.example.twitterclone.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDoa Doa;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adduser",consumes = "application/json", produces = "application/json")
    public String addUser(@RequestBody UserModel user) {
        System.out.println(user.toString());
        Doa.save(user);
        return "{status:'success'}";
    }
@CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json", produces = "application/json")
   public List<UserModel> login(@RequestBody UserModel user) {
        Doa.Userlogin(user.getEmail(),user.getPassword());
        return (List<UserModel>) Doa.Userlogin(user.getEmail(),user.getPassword());
    }



}
