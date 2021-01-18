package com.github.hieheihei.raliteweb.raquery.dao.impl;

import com.github.hieheihei.raliteweb.raquery.dao.IQueryDao;
import com.github.hieheihei.raliteweb.raquery.model.RAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class QueryDaoImpl implements IQueryDao {

    private DataSource ds;

    @Autowired
    public QueryDaoImpl(DataSource ds){
        this.ds = ds;
    }

    @Override
    public RAQuery.ResultData execute(String query) {
        try(Connection connection = ds.getConnection()){
            Statement stat = connection.createStatement();
            stat.setQueryTimeout(30);

            boolean hasResult = stat.execute(query);
            if(hasResult){
                ResultSet rs = stat.getResultSet();
                return RAQuery.parseResultData(rs);
            } else {
                return null;
            }

        } catch (SQLException e) {
            //todo
            throw new RuntimeException(e);
        }
    }


}
