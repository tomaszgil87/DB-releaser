package com.tgdevelopment.databases.DTO;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ObjectsDTO {

    private String name;
    private String type;
    private int line;
    private String text;

}
