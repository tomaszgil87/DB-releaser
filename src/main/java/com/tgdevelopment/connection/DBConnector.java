package com.tgdevelopment.connection;


public interface DBConnector {

    boolean isValid();
    void close();
    void create();

}
