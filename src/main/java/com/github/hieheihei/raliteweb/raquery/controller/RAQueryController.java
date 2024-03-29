package com.github.hieheihei.raliteweb.raquery.controller;

import com.github.hieheihei.raliteweb.Result;
import com.github.hieheihei.raliteweb.raquery.model.RAQuery;
import com.github.hieheihei.raliteweb.raquery.service.IRAQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/raQuery")
public class RAQueryController {

    private final IRAQueryService queryService;

    private static Logger logger = LoggerFactory.getLogger(RAQueryController.class);

    @Autowired
    public RAQueryController(IRAQueryService queryService){
        this.queryService = queryService;
    }

    /**
     * 执行RALite查询
     * @param model query:originalQueryStatement
     * @return RAQuery对象，包含查询语句，查询状态，查询结果
     */
    @PutMapping
    public Result<RAQuery> query(@RequestBody Map<String,String> model){
        Result<RAQuery> result = new Result<>();

        RAQuery q = new RAQuery();
        q.setQuery(queryService.parseQuery(model.get("query")));

        logger.info("query:"+q.getQuery());
        queryService.query(q);

        result.setModel(q);

        result.setStatus("OK");
        result.setMessage("查询成功");

        logger.info("resultData:\n"+q.getResultData());

        return result;
    }

}
