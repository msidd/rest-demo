package com.github.msidd.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.apache.xerces.internal.xs.StringList;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.pro

/**
 * Created by msidd on 11/20/2015.
 */
@Data
@ToString(exclude = "password")
@Document
public class User {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder() ;

    private final @Id
    String id;

    private String firstName;
    private String lastName;
    private String description;

    private String userName;
    private @JsonIgnore
    String password;
    public User(){
        this.firstName=null;
        this.lastName=null;
        this.description=null;
        this.userName=null;
        this.password=null;
        this.id=null;

    };
    public User(String firstName,String lastName,String description,String userName,String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.description=description;
        this.userName=userName;
        this.setPassword(password);
        this.id=null;

    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }
}
