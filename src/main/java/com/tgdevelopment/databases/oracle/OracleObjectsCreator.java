package com.tgdevelopment.databases.oracle;

import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.databases.DAO.ObjectsDAO;
import com.tgdevelopment.databases.DTO.ObjectsDTO;
import com.tgdevelopment.databases.ObjectsCreator;
import lombok.Value;

import java.util.List;

@Value
public class OracleObjectsCreator implements ObjectsCreator {

    DBConnector connector;
    ObjectsDAO objectsDAO;

    public OracleObjectsCreator(DBConnector connector) {
        this.connector = connector;
        this.objectsDAO = new ObjectsOracleDAO(connector);
    }

    @Override
    public void get() {
        List<ObjectsDTO> objects = objectsDAO.get();
        System.out.println("Success");
    }
}
