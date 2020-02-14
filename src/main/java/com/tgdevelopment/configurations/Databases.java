package com.tgdevelopment.configurations;

public enum Databases {

    ORACLE("ORACLE"),
    MYSQL("MYSQL"),
    MSSQL("MSSQL");

    private String value;

    private Databases(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
