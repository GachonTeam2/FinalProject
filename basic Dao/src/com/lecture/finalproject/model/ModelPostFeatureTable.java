package com.lecture.finalproject.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ModelPostFeatureTable {
    private static Logger logger = LoggerFactory
                                         .getLogger(ModelPostFeatureTable.class);
    
    private String table_name ;
    private int travelPost_no;
    public ModelPostFeatureTable(String table_name, int travelPost_no) {
        super();
        this.table_name = table_name;
        this.travelPost_no = travelPost_no;
    }
    public ModelPostFeatureTable() {
        super();
    }
    public static Logger getLogger() {
        return logger;
    }
    public static void setLogger(Logger logger) {
        ModelPostFeatureTable.logger = logger;
    }
    public String getTable_name() {
        return table_name;
    }
    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }
    public int getTravelPost_no() {
        return travelPost_no;
    }
    public void setTravelPost_no(int travelPost_no) {
        this.travelPost_no = travelPost_no;
    }
    @Override
    public String toString() {
        return "ModelPostFeatureTable [table_name=" + table_name
                + ", travelPost_no=" + travelPost_no + "]";
    }
    
    
   
}
