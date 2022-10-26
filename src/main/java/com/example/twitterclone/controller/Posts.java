package com.example.twitterclone.controller;

import com.example.twitterclone.doa.PostsDoa;
import com.example.twitterclone.model.PostsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@RestController
public class Posts {

    @Autowired
    private PostsDoa Doa;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addpost",consumes = "application/json", produces = "application/json")
    public String addPost(@RequestBody PostsModel post) {
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String CurrentDate=String.valueOf(dt.format(now));
        post.setPostdate(dt.format(now));
        System.out.println(post.toString());
        Doa.save(post);
        return "{status:'success'}";
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/viewposts")
    public List<Map<String,String>> viewallposts() {
        return (List<Map<String,String>>)Doa.ViewAllPosts();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/individual",consumes = "application/json", produces = "application/json")
    public List<Map<String,String>> individual(@RequestBody PostsModel post) {
        return (List<Map<String,String>>) Doa.individual(post.getUserid());
    }



}
