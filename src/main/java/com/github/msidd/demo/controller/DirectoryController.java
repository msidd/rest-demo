package com.github.msidd.demo.controller;

import com.github.msidd.demo.domain.File;
import com.github.msidd.demo.repo.DirectoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import java.util.List;

/**
 * Created by msidd on 11/20/2015.
 */

@RestController
public class DirectoryController {
    @Autowired
    private DirectoryRepository repository;

    @RequestMapping(value = "/directoryList")
    @ResponseBody

    //throws exception and return http 500 to the client if io exception occurs
    public List<File> displayList(@RequestParam(value="dirname",required = false) String name)throws IOException {

        return repository.listFiles(name);



    }
}
