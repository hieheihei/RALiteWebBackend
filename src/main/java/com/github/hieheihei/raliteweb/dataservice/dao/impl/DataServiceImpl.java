package com.github.hieheihei.raliteweb.dataservice.dao.impl;

import com.github.hieheihei.raliteweb.dataservice.dao.IDataServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataServiceImpl implements IDataServiceDao {

    private final DataSource ds;

    @Autowired
    public DataServiceImpl(DataSource ds){
        this.ds = ds;
    }

    @Override
    public List<String> selectTables() {
        try(Connection connection = ds.getConnection()){
            Statement stat = connection.createStatement();
            stat.setQueryTimeout(30);

            String sql = "select name from sqlite_master where type = 'table'";
            ResultSet rs = stat.executeQuery(sql);

            List<String> tables = new ArrayList<>();
            while (rs.next()){
                tables.add(rs.getString(1));
            }
            return tables;
        } catch (SQLException e) {
            //todo
            throw new RuntimeException(e);
        }
    }
}
