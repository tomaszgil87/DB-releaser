package com.tgdevelopment.dump.DTO;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class DumpObjectsDTO {

    private String name;
    private String type;
    private int line;
    private String text;

}
