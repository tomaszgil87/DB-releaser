package com.tgdevelopment.databases;

import com.tgdevelopment.connection.DBConnector;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.tgdevelopment.databases.ObjectsCreatorFactory.create;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class DatabaseService {

    public void get(DBConnector connector){
        Optional<ObjectsCreator> filesCreator = create(connector);
        filesCreator.ifPresent(ObjectsCreator::get);
    }

}
