package com.tgdevelopment.dump;

import com.tgdevelopment.dump.DAO.DumpDAO;
import com.tgdevelopment.dump.DTO.DumpObjectsDTO;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class DumpService {

    DumpDAO dumpDAO;

    public List<DumpObjectsDTO> getDumpList(Connection conn) {

        return getObjects(conn);
    }

    private List<DumpObjectsDTO> getObjects(Connection conn) {
        List<DumpObjectsDTO> result = new ArrayList<>();
        try {
            result = dumpDAO.getDumpObjects(conn);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

}
