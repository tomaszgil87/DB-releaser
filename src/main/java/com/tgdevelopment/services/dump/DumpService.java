package com.tgdevelopment.services.dump;

import com.tgdevelopment.DAO.DumpDAO;
import com.tgdevelopment.model.DumpObjectsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DumpService {

    private DumpDAO dumpDAO;

    @Autowired
    public DumpService(DumpDAO dumpDAO) {
        this.dumpDAO = dumpDAO;
    }

    public List<DumpObjectsDTO> getDumpList(Connection conn) {

        List<DumpObjectsDTO> result = new ArrayList<>();
        try {
            result = dumpDAO.getDumpObjects(conn);
        } catch(SQLException e) {
            System.out.println(e);
        }

        return result;
    }

}
