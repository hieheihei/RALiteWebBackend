package com.github.hieheihei.raliteweb.dataservice.controller;

import com.github.hieheihei.raliteweb.Result;
import com.github.hieheihei.raliteweb.dataservice.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/dataService")
public class DataServiceController {

    private final IDataService dataService;

    @Autowired
    public DataServiceController(IDataService dataService){
        this.dataService = dataService;
    }

    /**
     * 返回所有表的名称
     */
    @GetMapping("/tables")
    public Result<List<String>> getTables(){
        Result<List<String>> result = new Result<>();

        result.setModel(dataService.getTables());

        result.setStatus("OK");
        result.setMessage("查询成功");

        return result;
    }
}
