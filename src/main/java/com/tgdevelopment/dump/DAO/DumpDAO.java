package com.tgdevelopment.dump.DAO;

import com.tgdevelopment.dump.DTO.DumpObjectsDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DumpDAO {

    List<DumpObjectsDTO> getDumpObjects(Connection con) throws SQLException;

}
