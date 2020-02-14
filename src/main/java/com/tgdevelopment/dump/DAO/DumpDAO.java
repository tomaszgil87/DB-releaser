package com.tgdevelopment.dump.DAO;

import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.dump.DTO.DumpObjectsDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DumpDAO {

    List<DumpObjectsDTO> getDumpObjects(DBConnector connector) throws SQLException;

}
