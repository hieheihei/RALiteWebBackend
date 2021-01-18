package com.github.hieheihei.raliteweb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result<T> {

    private String status;      //{"OK","ERROR"}
    private String message;

    private T model;
    private List<T> models;

    private Map<String, Integer> intMap = new HashMap<>();
    private Map<String, Double> doubleMap = new HashMap<>();
    private Map<String, String> stringMap = new HashMap<>();

    public String getStatus() {
        return status;
    }

    public Result<T> setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getModel() {
        return model;
    }

    public Result<T> setModel(T model) {
        this.model = model;
        return this;
    }

    public List<T> getModels() {
        return models;
    }

    public Result<T> setModels(List<T> models) {
        this.models = models;
        return this;
    }

    public Map<String, Integer> getIntMap() {
        return intMap;
    }

    public Result<T> setIntMap(Map<String, Integer> intMap) {
        this.intMap = intMap;
        return this;
    }

    public Map<String, Double> getDoubleMap() {
        return doubleMap;
    }

    public Result<T> setDoubleMap(Map<String, Double> doubleMap) {
        this.doubleMap = doubleMap;
        return this;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public Result<T> setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
        return this;
    }
}
