package com.tgdevelopment.dump;

import com.tgdevelopment.connection.DBConnector;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class DumpService {

    public void dump(DBConnector connector){
        Optional<FilesCreator> filesCreator = ofNullable(FilesCreatorFactory.create(connector));
        filesCreator.ifPresent(FilesCreator::dump);
    }

}
