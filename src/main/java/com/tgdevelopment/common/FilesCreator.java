package com.tgdevelopment.common;

import com.tgdevelopment.model.DumpObjectsDTO;
import com.tgdevelopment.services.dump.DumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
public class FilesCreator {

    private final DumpService dumpService;

    @Autowired
    public FilesCreator(DumpService dumpService) {
        this.dumpService = dumpService;
    }

    public void createFiles(Connection connection) {
        List<DumpObjectsDTO> objects = dumpService.getDumpList(connection);
    }
}
