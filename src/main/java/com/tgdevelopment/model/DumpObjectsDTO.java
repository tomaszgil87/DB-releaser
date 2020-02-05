package com.tgdevelopment.model;

import lombok.Builder;

@Builder
public class DumpObjectsDTO {

    private String name;
    private String type;
    private int line;
    private String text;

    private  DumpObjectsDTO() { }

}
