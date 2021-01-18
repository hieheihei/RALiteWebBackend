package com.github.hieheihei.raliteweb.raquery.service.impl;

import com.github.hieheihei.raliteweb.raquery.dao.IQueryDao;
import com.github.hieheihei.raliteweb.raquery.model.RAQuery;
import com.github.hieheihei.raliteweb.raquery.service.IRAQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RAQueryServiceImpl implements IRAQueryService {

    private IQueryDao queryDao;

    @Autowired
    public RAQueryServiceImpl(IQueryDao queryDao){
        this.queryDao = queryDao;
    }

    @Override
    public void query(RAQuery q) {
        RAQuery.ResultData resultData = queryDao.execute(q.getQuery());
        q.setHasExecuted(true);
        q.setHasResult(resultData != null);
        q.setResultData(resultData);
    }
}
