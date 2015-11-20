package com.github.msidd.demo.domain;


import lombok.Data;

/**
 * Created by msidd on 11/20/2015.
 */

@Data
public class File {

    String fileName;
    //String @todo add more properties of the file to display to the user

    public File(String name){
        this.fileName=name;

    }


}
