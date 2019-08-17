package com.danboisemechanical.DanboiseControls.se.models.n2;

import javax.baja.control.BEnumWritable;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatus;
import javax.baja.status.BStatusNumeric;
import javax.baja.sys.Context;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType

public class BJciN2EnumWritable extends BEnumWritable {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.models.n2.BJciN2EnumWritable(2979906276)1.0$ @*/
/* Generated Thu Aug 15 11:08:14 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BJciN2EnumWritable.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    @Override
    public void started(){
        if(this.get("in8").isNull() && this.get("in1").isNull()){
            ((BStatusNumeric)this.get("out")).setStatus(BStatus.ok);
        }else{
            ((BStatusNumeric)this.get("out")).setStatus(BStatus.overridden);
        }
    }

    @Override
    public void changed(Property prop, Context cx){
        if(this.get(prop).asComponent().getName().equals("in1") ||
                this.get(prop).asComponent().getName().equals("in8")){
            if(this.get("in8").isNull() && this.get("in1").isNull()){
                ((BStatusNumeric)this.get("out")).setStatus(BStatus.ok);
            }else{
                ((BStatusNumeric)this.get("out")).setStatus(BStatus.overridden);
            }
        }
    }
}
