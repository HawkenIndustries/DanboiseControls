package com.danboisemechanical.DanboiseControls.alarms;

import javax.baja.alarm.ext.BAlarmSourceExt;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType

public class BSetpointErrorAlarmExt extends BAlarmSourceExt{
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.alarms.BSetpointErrorAlarmExt(2979906276)1.0$ @*/
/* Generated Wed May 22 14:32:03 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSetpointErrorAlarmExt.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/


  //PRIVATE FIELDS

  //PARENT CLASS OVERRIDES
  @Override
  public void started() throws Exception{
    super.started();
  }
}
