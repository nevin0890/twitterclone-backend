package com.example.twitterclone.doa;

import com.example.twitterclone.model.PostsModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface PostsDoa extends CrudRepository<PostsModel, Integer> {

    @Query(value = "SELECT p.id, p.`message`, p.`postdate`,p.userid , u.name FROM `posts` p JOIN user u ON u.id=p.userid",nativeQuery = true)
    List<Map<String,String>>ViewAllPosts();

    @Query(value="SELECT p.id, p.`message`, p.`postdate`,p.userid , u.name FROM `posts` p JOIN user u ON u.id=p.userid WHERE p.`userid`=:userid",nativeQuery = true)
    List<Map<String,String>>individual(int userid);

}

