package com.tgdevelopment.DAO.oracle;

import com.tgdevelopment.model.oracle.DumpObjects;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Repository
public class DumpOracleDAO {


    public List<DumpObjects> getDumpObjects(Connection con) throws SQLException {
        String query = "select name, type, line, text " +
                        "from user_source us " +
                        "where us.type in ('PACKAGE', 'PACKAGE BODY', 'PROCEDURE', 'FUNCTION', 'TRIGGER', 'TYPE') " +
                        "order by name, type, line";

        List<DumpObjects> results = new LinkedList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                results.add(DumpObjects.builder()
                                       .withName(rs.getString("name"))
                                       .withText(rs.getString("text"))
                                       .withLine(rs.getInt("line"))
                                       .withType(rs.getString("type"))
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
