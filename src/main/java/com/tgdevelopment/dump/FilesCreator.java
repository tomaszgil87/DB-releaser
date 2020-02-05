package com.tgdevelopment.dump;

import com.tgdevelopment.dump.DTO.DumpObjectsDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

@Service
@AllArgsConstructor
public class FilesCreator {

    private final DumpService dumpService;

    public void createFiles(Connection connection) {
        List<DumpObjectsDTO> objects = dumpService.getDumpList(connection);
    }
}
