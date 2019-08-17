package com.danboisemechanical.DanboiseControls.se.builders;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

@NiagaraType

public class BDMOBuilder extends BPRNBuilder {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.builders.BDMOBuilder(2979906276)1.0$ @*/
/* Generated Wed Aug 14 16:25:34 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDMOBuilder.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    public static BDMOBuilder make(){ return new BDMOBuilder(); }
}
