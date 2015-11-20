package com.github.msidd.demo.repo;

import com.github.msidd.demo.domain.File;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msidd on 11/20/2015.
 */
@Component
public class DirectoryRepository

        //extends PagingAndSortingRepository<Directory,String> there is no easy documentation available to implement
{

    //create the files objects
    public List<File> listFiles(String directoryName) throws IOException {
        List<File> files = new ArrayList<File>();
        if (directoryName == null) {
            Path currentRelativePath = Paths.get("");
            directoryName = currentRelativePath.toAbsolutePath().toString();

        }

        Files.walk(Paths.get(directoryName)).forEach(filePath -> {
            if (Files.isRegularFile(filePath)) {
                File file = new File(filePath.getFileName().toString());
                files.add(file);

            }
        });
        return files;

    }
}
