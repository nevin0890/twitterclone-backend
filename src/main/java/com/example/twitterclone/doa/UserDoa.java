package com.example.twitterclone.doa;

import com.example.twitterclone.model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDoa extends CrudRepository<UserModel, Integer> {

    @Query(value="SELECT `id`, `dob`, `email`, `name`, `number`, `password`, `place` FROM `user` WHERE `email`=:email AND`password`=:password",nativeQuery = true)
    List <UserModel> Userlogin(String email, String password);

}

