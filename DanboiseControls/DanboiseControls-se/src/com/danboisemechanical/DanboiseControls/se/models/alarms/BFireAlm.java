package com.danboisemechanical.DanboiseControls.se.models.alarms;

import javax.baja.alarm.ext.offnormal.BBooleanChangeOfStateAlgorithm;
import javax.baja.control.BControlPoint;
import javax.baja.control.ext.BNullProxyExt;
import javax.baja.driver.point.BPointDeviceExt;
import javax.baja.driver.point.BPointFolder;
import javax.baja.driver.point.BProxyExt;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BFormat;

@NiagaraType

public class BFireAlm extends BAbstractAlarmType{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.models.alarms.BFireAlm(2979906276)1.0$ @*/
/* Generated Fri Apr 12 14:41:05 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFireAlm.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  /**METHODS**/

  /**
   *Makes and returns the alarm's metadata
   * @param geoCode: building's geolocation code
   * @param id: alarm id code to designate multiple alarms of the same type
   * @Return BFacets
   * **/
@Override
  public BFacets makeMetadata(String geoCode, String id){
    String[] metaTags = {"GLC", "Zone", "ID", "AlarmType"};
    BString[] metaValues = {BString.make(geoCode), BString.make("NGF".concat(id)),
            BString.make("01"), BString.make("EF")};

    BFacets meta = BFacets.make(metaTags, metaValues);

    return meta;
  }

  /**
   *Makes and returns the alarm's source name as a literal string of BFormat type. The method finds out if the object
   * supplied is point, and whether the proxyExt is null. If the point has a proxy, the method checks the pointExt for
   * point folders, if there are points folders, the method determines it is a N2, or gateway like integration and
   * finds the parent component of the point, provided it is a point folder type of object, the method gets the
   * display names and formats them before returning.
   * @param point: BObject, it should cast down to a controlPoint or else it will throw an exception.
   * @Return BFormat
   * **/
  @Override
  public BFormat makeSourceName(BObject point){
    BFormat srcName = null;
    boolean isGateway = false;
    try{
      BControlPoint p = (BControlPoint)point;
      BComponent c = (BComponent)point;
      if(!(p.getProxyExt() instanceof BNullProxyExt)){
        BPointDeviceExt dExt = ((BProxyExt)p.getProxyExt()).getDeviceExt();
        BComponent[] children = ((BComponent)dExt).getChildComponents();
        for(int i  = 0; i < children.length; i++){
          if(children[i] instanceof BPointFolder){
            isGateway = true;
            break;
          }
        }
        if(isGateway){
          srcName = BFormat.make(c.getParent().getDisplayName(null).concat(","+ c.getDisplayName(null)));
        }else{
          srcName = BFormat.make(dExt.getDevice().getDisplayName(null).concat(","+ p.getDisplayName(null)));
        }
      }
    }catch(Exception e){e.printStackTrace();}
    if(srcName.isNull()){srcName = BFormat.make("ERROR...makeSourceName()");}
    return srcName;
  }

  /**
   * Receives a boolean input to determine if the message is for an active or normal alarm condition; it creates an
   * Alarm message on the calling object based on that criteria.
   * @param isActiveAlarm: Boolean, determines wheteher the message is for an active or normal alarm condition.
   * @return BFormat
   * */
@Override
  public BFormat makeAlarmMsg(Boolean isActiveAlarm){
    BFormat text = null;
    if(isActiveAlarm){
      text = BFormat.make("FIRE ALARM IS ACTIVE");
    }else{
      text = BFormat.make("FIRE ALARM HAS CLEARED");
    }
    return text;
  }

  /***
   * Makes the alarm offnormal algorithm in the caller's property sheet.
   * @return BBooleanChangeOfStateAlgorithm
   * */
  @Override
  public BBooleanChangeOfStateAlgorithm makeAlgrthm(){
    BBooleanChangeOfStateAlgorithm boolCovAlg = new BBooleanChangeOfStateAlgorithm();
    boolCovAlg.setAlarmValue(true);
    return boolCovAlg;
  }
}
