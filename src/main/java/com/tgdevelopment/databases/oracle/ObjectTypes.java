package com.tgdevelopment.databases.oracle;

public enum ObjectTypes {

    PACKAGE("PACKAGE"),
    PACKAGE_BODY("PACKAGE BODY"),
    PROCEDURE("PROCEDURE"),
    FUNCTION("FUNCTION"),
    TRIGGER("TRIGGER"),
    TYPE("TYPE");

    private String value;

    private final static String SQL_QUATATION = "'";
    private final static String SEPARATOR = ", ";

    ObjectTypes(String value) {
        this.value = value;
    }

    public static String createSqlFilter() {
        StringBuilder str = new StringBuilder();
        for (ObjectTypes o : ObjectTypes.values()) {
            str.append(SEPARATOR + SQL_QUATATION).append(o.value).append(SQL_QUATATION);
        }
        return str.toString().replaceFirst(SEPARATOR, "");
    }

}
