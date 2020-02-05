package com.tgdevelopment.services.dump;

import com.tgdevelopment.DAO.DumpDAO;
import com.tgdevelopment.model.DumpObjectsDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class DumpService {

    private final DumpDAO dumpDAO;

    public List<DumpObjectsDTO> getDumpList(Connection conn) {

        return getObjects(conn);
    }

    private List<DumpObjectsDTO> getObjects(Connection conn) {
        List<DumpObjectsDTO> result = new ArrayList<>();
        try {
            result = dumpDAO.getDumpObjects(conn);
        } catch(SQLException e) {
            System.out.println(e);
        }

        return result;
    }

}
