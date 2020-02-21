package com.tgdevelopment.databases.oracle;

import com.tgdevelopment.connection.DBConnector;
import com.tgdevelopment.connection.exceptions.ConnectionException;
import com.tgdevelopment.databases.DAO.ObjectsDAO;
import com.tgdevelopment.databases.DTO.ObjectsDTO;
import com.tgdevelopment.databases.Query;
import com.tgdevelopment.databases.QueryBuilder;
import lombok.Value;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static com.tgdevelopment.databases.oracle.OracleQueries.GET_OBJECTS_WITH_TYPES;

@Value
public class ObjectsOracleDAO implements ObjectsDAO {

    DBConnector connector;

    @Override
    public List<ObjectsDTO> get() {

        List<ObjectsDTO> results = new LinkedList<>();

        Query query = QueryBuilder.builder(GET_OBJECTS_WITH_TYPES)
                                  .withParameter("types", ObjectTypes.createSqlFilter())
                                  .build();

        try(PreparedStatement stmt = this.connector.getConnection().prepareStatement(query.getQuery());
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                results.add(ObjectsDTO.builder()
                                       .name(rs.getString("name"))
                                       .text(rs.getString("text"))
                                       .type(rs.getString("type"))
                                       .build()
                                       );
            }
        } catch (SQLException e ) {
            throw new ConnectionException(e.getMessage());
        }

        return results;
    }
}
