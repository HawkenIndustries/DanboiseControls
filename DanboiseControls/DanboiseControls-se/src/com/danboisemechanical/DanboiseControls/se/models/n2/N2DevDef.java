package com.danboisemechanical.DanboiseControls.se.models.n2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class N2DevDef {

    //FIELDS
    private LocalDate configDate = null;
    private String engUnits = "";
    private String devGroup = "";
    private String devName = "";
    private  String appName = "";

    //METHODS
    public LocalDate getConfigDate(){ return configDate; }
    public String getEngUnits(){ return engUnits; }
    public String getDevGroup(){ return devGroup; }
    public String getDevName(){ return devName; }
    public String getAppName(){ return appName; }

    public static N2DevDef make(String date, String units, String group, String name, String app){

        DateTimeFormatter dt = DateTimeFormatter.ofPattern("MM/dd/uuuu");

        N2DevDef dev = new N2DevDef();

        dev.configDate = LocalDate.parse(date,dt);
        dev.engUnits = units;
        dev.devGroup = group;
        dev.devName = name;
        dev.appName = app;

        return dev;
    }
}
