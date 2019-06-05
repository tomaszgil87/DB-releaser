package com.tgdevelopment.DAO.oracle;

import com.tgdevelopment.DAO.DumpDAO;
import com.tgdevelopment.model.DumpObjectsDTO;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DumpOracleDAO implements DumpDAO {

    @Override
    public List<DumpObjectsDTO> getDumpObjects(Connection con) throws SQLException {
        String query = "select name, type, LISTAGG(text, chr(13)) WITHIN GROUP (ORDER BY name, type, line) AS text " +
                        "from user_source us " +
                        "where us.type in ('PACKAGE', 'PACKAGE BODY', 'PROCEDURE', 'FUNCTION', 'TRIGGER', 'TYPE') " +
                        "group by name, type " +
                        "order by name, type ";

        List<DumpObjectsDTO> results = new LinkedList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                results.add(DumpObjectsDTO.builder()
                                       .withName(rs.getString("name"))
                                       .withText(rs.getString("text"))
                                       .withType(rs.getString("type"))
                                       .build()
                                       );
            }
        } catch (SQLException e ) {
            System.out.print(e);
        } finally {
            if(stmt != null) {stmt.close();}
            if(rs != null) {rs.close();}
        }

        return results;
    }

}
