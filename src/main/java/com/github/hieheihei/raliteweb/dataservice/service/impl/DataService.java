package com.github.hieheihei.raliteweb.dataservice.service.impl;

import com.github.hieheihei.raliteweb.dataservice.dao.IDataServiceDao;
import com.github.hieheihei.raliteweb.dataservice.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService implements IDataService {

    private final IDataServiceDao dataServiceDao;

    @Autowired
    public DataService(IDataServiceDao dataServiceDao){
        this.dataServiceDao = dataServiceDao;
    }

    @Override
    public List<String> getTables() {
        return dataServiceDao.selectTables();
    }

}
