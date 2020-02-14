package com.tgdevelopment.dump.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.nio.file.Path;
import java.sql.Connection;

@AllArgsConstructor
@Value
@Getter
public class FilesDTO {

    private final Connection connection;
    private final Path directory;

}
