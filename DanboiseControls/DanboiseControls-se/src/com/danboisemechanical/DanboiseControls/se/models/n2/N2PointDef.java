package com.danboisemechanical.DanboiseControls.se.models.n2;

public class N2PointDef {

    //FIELDS
    private String pointType = "";
    private int pointAddress = 0;
    private String longName = "";
    private String shortName = "";
    private String pointUnits = "";

    //METHOD
    public String getPointType(){ return pointType; }
    public int getPointAddress(){ return pointAddress; }
    public String getLongName(){ return longName; }
    public String getShortName(){ return shortName; }
    public String getPointUnits(){ return pointUnits; }

    public static N2PointDef make(String pType, int address,  String lName, String sName, String u){

        N2PointDef pointDefObj = new N2PointDef();
        pointDefObj.pointType = pType;
        pointDefObj.pointAddress = address;
        pointDefObj.longName = lName;
        pointDefObj.shortName = sName;
        try{
            pointDefObj.pointUnits = u;
        }catch(NullPointerException npe){}

        return pointDefObj;
    }
}
