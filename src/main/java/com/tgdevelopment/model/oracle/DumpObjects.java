package com.tgdevelopment.model.oracle;

public class DumpObjects {

    private String name;

    private String type;

    private int line;

    private String text;

    public DumpObjects() {

    }

    private DumpObjects(String name, String type, int line, String text) {
        this.line = line;
        this.name = name;
        this.text = text;
        this.type = type;
    }

    public DumpObjects withName(String name) {
        this.name = name;
        return this;
    }

    public DumpObjects withType(String type) {
        this.type = type;
        return this;
    }

    public DumpObjects withText(String text) {
        this.text = text;
        return this;
    }

    public DumpObjects withLine(int line) {
        this.line = line;
        return this;
    }

    public static DumpObjects builder() {
        return new DumpObjects();
    }

}
