package com.tgdevelopment.model;

import java.nio.file.Path;
import java.sql.Connection;

public class FilesDTO {

    private Connection connection;

    private Path directory;

    public FilesDTO(Connection connection, Path directory) {
        this.connection = connection;
        this.directory = directory;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public Path getDirectory() {
        return this.directory;
    }

}
