package com.tgdevelopment.dump.controllers;

import com.tgdevelopment.dump.FilesCreator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class DbController {

    private final FilesCreator filesCreator;

    public void dumpFiles(String directory) {

    }

}
