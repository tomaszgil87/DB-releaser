package com.tgdevelopment.DAO;

import com.tgdevelopment.model.DumpObjectsDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DumpDAO {

    List<DumpObjectsDTO> getDumpObjects(Connection con) throws SQLException;

}
