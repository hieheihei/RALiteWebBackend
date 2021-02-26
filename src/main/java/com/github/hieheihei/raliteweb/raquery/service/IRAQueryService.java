package com.github.hieheihei.raliteweb.raquery.service;

import com.github.hieheihei.raliteweb.raquery.model.RAQuery;

public interface IRAQueryService {

    String parseQuery(String originQuery);

    void query(RAQuery q);

}
