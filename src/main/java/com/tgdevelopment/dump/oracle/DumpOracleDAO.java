package com.tgdevelopment.dump.oracle;

import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.connection.exceptions.ConnectionException;
import com.tgdevelopment.dump.DAO.DumpDAO;
import com.tgdevelopment.dump.DTO.DumpObjectsDTO;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DumpOracleDAO implements DumpDAO {

    @Override
    public List<DumpObjectsDTO> getDumpObjects(DBConnector connector) {


        List<DumpObjectsDTO> results = new LinkedList<>();
        try(Statement stmt = connector.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("GET_OBJECTS")) {
            while (rs.next()) {
                results.add(DumpObjectsDTO.builder()
                                       .name(rs.getString("name"))
                                       .text(rs.getString("text"))
                                       .type(rs.getString("type"))
                                       .build()
                                       );
            }
        } catch (SQLException e ) {
            System.out.print(e);
            throw new ConnectionException(e.getMessage());
        }

        return results;
    }
}
