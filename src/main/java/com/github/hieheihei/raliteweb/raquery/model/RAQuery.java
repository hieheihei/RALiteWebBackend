package com.github.hieheihei.raliteweb.raquery.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RAQuery {

    private String query = null;
    private boolean hasExecuted = false;
    private boolean hasResult = false;
    private ResultData resultData = null;


    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public boolean isHasExecuted() {
        return hasExecuted;
    }

    public void setHasExecuted(boolean hasExecuted) {
        this.hasExecuted = hasExecuted;
    }

    public boolean isHasResult() {
        return hasResult;
    }

    public void setHasResult(boolean hasResult) {
        this.hasResult = hasResult;
    }

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }

    public static ResultData parseResultData(ResultSet rs) throws SQLException {
        return new ResultData(rs);
    }

    public static class ResultData{
        private String[] colNames;
        private List<String[]> data = new ArrayList<>();

        public ResultData(ResultSet rs) throws SQLException {
            parseColNames(rs);
            parseData(rs);
        }

        private void parseColNames(ResultSet rs) throws SQLException {
            ResultSetMetaData md = rs.getMetaData();

            int colNum = md.getColumnCount();
            colNames = new String[colNum];
            for(int i = 0; i<colNum; i++){
                colNames[i] = md.getColumnName(i+1);
            }
        }

        private void parseData(ResultSet rs) throws SQLException {
            while (rs.next()){
                String[] row = new String[colNames.length];
                for(int i = 0; i<colNames.length;i++){
                    row[i] = rs.getString(i+1);
                }
                data.add(row);
            }
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append(Arrays.toString(colNames));
            sb.append('\n');
            for(String[] row : data){
                sb.append(Arrays.toString(row));
                sb.append('\n');
            }
            return sb.toString();
        }
    }
}

