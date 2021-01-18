package com.github.hieheihei.raliteweb.raquery.controller;

import com.github.hieheihei.raliteweb.Result;
import com.github.hieheihei.raliteweb.raquery.model.RAQuery;
import com.github.hieheihei.raliteweb.raquery.service.IRAQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/raQuery")
public class RAQueryController {

    private IRAQueryService queryService;

    @Autowired
    public RAQueryController(IRAQueryService queryService){
        this.queryService = queryService;
    }

    @PostMapping
    public Result<RAQuery> query(RAQuery q){
        Result<RAQuery> result = new Result<>();

        queryService.query(q);
        result.setModel(q);

        result.setStatus("OK");
        result.setMessage("查询成功");

        return result;
    }

}
