package com.tgdevelopment.dump;

import com.tgdevelopment.dump.DTO.DumpObjectsDTO;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class FilesCreator {

    DumpService dumpService;

    public List<DumpObjectsDTO> createFiles(Connection connection) {
        List<DumpObjectsDTO> objects = dumpService.getDumpList(connection);
        return objects;
    }
}
