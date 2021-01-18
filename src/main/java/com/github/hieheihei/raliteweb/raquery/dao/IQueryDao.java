package com.github.hieheihei.raliteweb.raquery.dao;

import com.github.hieheihei.raliteweb.raquery.model.RAQuery;

public interface IQueryDao {

    RAQuery.ResultData execute(String query);
}
