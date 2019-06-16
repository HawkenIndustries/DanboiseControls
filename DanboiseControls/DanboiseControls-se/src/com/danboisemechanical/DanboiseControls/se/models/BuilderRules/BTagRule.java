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
        name = "PointNameHint",
        type = "baja:String",
        defaultValue = "BString.make(\"\")",
        flags = Flags.SUMMARY
)

public class BTagRule extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.models.BuilderRules.BTagRule(3256581577)1.0$ @*/
/* Generated Wed Jun 12 17:37:10 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

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
// Property "PointNameHint"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code PointNameHint} property.
   * @see #getPointNameHint
   * @see #setPointNameHint
   */
  public static final Property PointNameHint = newProperty(Flags.SUMMARY, BString.make(""), null);
  
  /**
   * Get the {@code PointNameHint} property.
   * @see #PointNameHint
   */
  public String getPointNameHint() { return getString(PointNameHint); }
  
  /**
   * Set the {@code PointNameHint} property.
   * @see #PointNameHint
   */
  public void setPointNameHint(String v) { setString(PointNameHint, v, null); }

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
