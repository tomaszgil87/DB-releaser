package com.tgdevelopment.services.dump;

import com.tgdevelopment.DAO.oracle.DumpOracleDAO;
import com.tgdevelopment.model.oracle.DumpObjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DumpOracleService {

    private DumpOracleDAO dumpOracleDAO;

    @Autowired
    public DumpOracleService(DumpOracleDAO dumpOracleDAO) {
        this.dumpOracleDAO = dumpOracleDAO;
    }

    public List<DumpObjects> getDumpList(Connection conn) {

        List<DumpObjects> result = new ArrayList<>();
        try {
            result = dumpOracleDAO.getDumpObjects(conn);
        } catch(SQLException e) {
            System.out.println(e);
        }

        return result;
    }

}
