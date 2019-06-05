package com.tgdevelopment.controllers;

import com.tgdevelopment.common.FilesCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DbController {

    private final FilesCreator filesCreator;

    @Autowired
    public DbController(FilesCreator filesCreator) {
        this.filesCreator = filesCreator;
    }

    public void dumpFiles(String directory) {

    }

}
