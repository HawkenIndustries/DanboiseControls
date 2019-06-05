package com.danboisemechanical.DanboiseControls.ux;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.AgentOn;
import javax.baja.nre.annotations.NiagaraSingleton;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BSingleton;
import javax.baja.sys.Context;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.web.BIFormFactorMax;
import javax.baja.web.js.BIJavaScript;
import javax.baja.web.js.JsInfo;

@NiagaraSingleton
@NiagaraType(
        agent = @AgentOn(
                types = {"driver:Device"}
        )
)

public class BFloorplanZone extends BSingleton implements BIJavaScript, BIFormFactorMax {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.ux.BFloorplanZone(4053533213)1.0$ @*/
/* Generated Tue Jun 04 13:22:08 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */
  
  public static final BFloorplanZone INSTANCE = new BFloorplanZone();

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BFloorplanZone.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    private static final JsInfo jsInfo = JsInfo.make(BOrd.make("module://DanboiseControls/res/js/FloorplanZone.js"));

    @Override
    public JsInfo getJsInfo(Context cx){return jsInfo;}
}
