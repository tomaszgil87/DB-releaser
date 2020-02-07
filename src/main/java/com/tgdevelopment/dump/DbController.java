package com.tgdevelopment.dump;

import com.tgdevelopment.dump.DTO.DumpObjectsDTO;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Controller
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class DbController {

    FilesCreator filesCreator;

    public void dumpFiles(String directory) {
        List<DumpObjectsDTO> objects = filesCreator.createFiles(null);
    }

}
