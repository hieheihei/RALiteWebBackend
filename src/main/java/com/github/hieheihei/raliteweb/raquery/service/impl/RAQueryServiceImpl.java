package com.github.hieheihei.raliteweb.raquery.service.impl;

import com.github.hieheihei.raliteweb.raquery.dao.IQueryDao;
import com.github.hieheihei.raliteweb.raquery.model.RAQuery;
import com.github.hieheihei.raliteweb.raquery.service.IRAQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RAQueryServiceImpl implements IRAQueryService {

    private IQueryDao queryDao;

    private static final HashMap<String,String> parseMap = new HashMap<>();
    static {
        parseMap.put("<p>","");
        parseMap.put("</p>","");
        parseMap.put("<br>","");

        parseMap.put("&nbsp;"," ");

        parseMap.put("&gt;",">");
        parseMap.put("&lt;","<");

        parseMap.put("&pi;","RA_PROJECTION");
        parseMap.put("&sigma;","RA_SELECT");
        parseMap.put("&cap;","RA_INTERSECT");
        parseMap.put("&cup;","RA_UNION");
        parseMap.put("-","RA_EXCEPT");
        parseMap.put("⨯","RA_INNER_JOIN");
        parseMap.put("⨝","RA_NATURE_JOIN");
    }

    @Autowired
    public RAQueryServiceImpl(IQueryDao queryDao){
        this.queryDao = queryDao;
    }

    @Override
    public String parseQuery(String originQuery) {
        String query = originQuery;
        for(Map.Entry<String,String> e : parseMap.entrySet()){
            query = query.replaceAll(e.getKey(),e.getValue());
        }
        query += ";";
        return query;
    }

    @Override
    public void query(RAQuery q) {
        RAQuery.ResultData resultData = queryDao.execute(q.getQuery());
        q.setHasExecuted(true);
        q.setHasResult(resultData != null);
        q.setResultData(resultData);
    }
}
