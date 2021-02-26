package com.github.hieheihei.raliteweb;

import com.github.hieheihei.raliteweb.raquery.dao.IQueryDao;
import com.github.hieheihei.raliteweb.raquery.model.RAQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootTest
class RalitewebApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private IQueryDao queryDao;

    @Test
    void contextLoads() {
    }

    @Test
    void daoTest(){
//        RAQuery.ResultData data = queryDao.execute("select * from tbA;");
//        queryDao.execute("insert into tbA (a,b) values (2,2)");
        RAQuery.ResultData data = queryDao.execute("tbA;");

        System.out.println(data);

    }

}
