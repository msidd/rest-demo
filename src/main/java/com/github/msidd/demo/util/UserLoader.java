package com.github.msidd.demo.util;

import com.github.msidd.demo.domain.User;
import com.github.msidd.demo.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by msidd on 11/20/2015.
 * this class loads users into db via user rep
 * this class doesn't tear down the database
 */

@Slf4j
@Component
public class UserLoader {


    @Autowired
    public UserLoader(UserRepository repository){

        //if there are some users in the database don't do anything
        if (repository.count() != 0) {
            return;
        }
        repository.save(readUsers());
        log.info("Successfully imported {} users.", repository.count());


    }
    //this method loads users from within the code and can easily be enhanced to load users from file
    public static List<User> readUsers(){
        List <User>users =new ArrayList<User>();

        for(int i=0;i<10;i++) {
            User user = new User("User"+i, "LastName1"+i, "description"+i, "msidd"+i, "user"+i);
            users.add(user);
        }

        return users;

    }

}
