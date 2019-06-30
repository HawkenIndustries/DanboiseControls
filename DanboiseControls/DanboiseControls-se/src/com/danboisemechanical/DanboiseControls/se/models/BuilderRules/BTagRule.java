package com.danboisemechanical.DanboiseControls.se.models.BuilderRules;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType

@NiagaraProperty(
        name = "TargetId",
        type = "baja:String",
        defaultValue = "BString.make(\"\")",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "NiagaraType",
        type = "baja:String",
        defaultValue = "BString.make(\"\")",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "PointNames",
        type = "baja:String",
        defaultValue = "BString.make(\"\")",
        flags = Flags.SUMMARY
)

public class BTagRule extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.models.BuilderRules.BTagRule(2407661259)1.0$ @*/
/* Generated Wed Jun 26 09:43:01 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "TargetId"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code TargetId} property.
   * @see #getTargetId
   * @see #setTargetId
   */
  public static final Property TargetId = newProperty(Flags.SUMMARY, BString.make(""), null);
  
  /**
   * Get the {@code TargetId} property.
   * @see #TargetId
   */
  public String getTargetId() { return getString(TargetId); }
  
  /**
   * Set the {@code TargetId} property.
   * @see #TargetId
   */
  public void setTargetId(String v) { setString(TargetId, v, null); }

////////////////////////////////////////////////////////////////
// Property "NiagaraType"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code NiagaraType} property.
   * @see #getNiagaraType
   * @see #setNiagaraType
   */
  public static final Property NiagaraType = newProperty(Flags.SUMMARY, BString.make(""), null);
  
  /**
   * Get the {@code NiagaraType} property.
   * @see #NiagaraType
   */
  public String getNiagaraType() { return getString(NiagaraType); }
  
  /**
   * Set the {@code NiagaraType} property.
   * @see #NiagaraType
   */
  public void setNiagaraType(String v) { setString(NiagaraType, v, null); }

////////////////////////////////////////////////////////////////
// Property "PointNames"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code PointNames} property.
   * @see #getPointNames
   * @see #setPointNames
   */
  public static final Property PointNames = newProperty(Flags.SUMMARY, BString.make(""), null);
  
  /**
   * Get the {@code PointNames} property.
   * @see #PointNames
   */
  public String getPointNames() { return getString(PointNames); }
  
  /**
   * Set the {@code PointNames} property.
   * @see #PointNames
   */
  public void setPointNames(String v) { setString(PointNames, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTagRule.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public static BTagRule make(){
    return new BTagRule();
  }
}
