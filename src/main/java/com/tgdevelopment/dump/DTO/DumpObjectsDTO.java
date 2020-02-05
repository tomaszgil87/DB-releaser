package com.tgdevelopment.dump.DTO;

import lombok.Builder;

@Builder
public class DumpObjectsDTO {

    private String name;
    private String type;
    private int line;
    private String text;

}
