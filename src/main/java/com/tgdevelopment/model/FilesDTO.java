package com.tgdevelopment.model;

import lombok.AllArgsConstructor;

import java.nio.file.Path;
import java.sql.Connection;

@AllArgsConstructor
public class FilesDTO {

    private final Connection connection;

    private final Path directory;


    public Connection getConnection() {
        return this.connection;
    }

    public Path getDirectory() {
        return this.directory;
    }

}
