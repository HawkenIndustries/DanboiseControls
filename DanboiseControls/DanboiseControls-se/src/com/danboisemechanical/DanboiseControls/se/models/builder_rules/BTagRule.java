package com.danboisemechanical.DanboiseControls.se.models.builder_rules;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

@NiagaraType

@NiagaraProperty(
        name = "ns",
        type = "baja:String",
        defaultValue = "BString.make(\"\")"
)
@NiagaraProperty(
        name = "tag",
        type = "baja:String",
        defaultValue = "BString.make(\"\")"
)
@NiagaraProperty(
        name = "types",
        type = "baja:String",
        defaultValue = "BString.make(\"\")"
)
@NiagaraProperty(
        name = "PointNames",
        type = "baja:String",
        defaultValue = "BString.make(\"\")"
)

public class BTagRule extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.models.builder_rules.BTagRule(4043345574)1.0$ @*/
/* Generated Tue Jul 02 14:11:48 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "ns"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code ns} property.
   * @see #getNs
   * @see #setNs
   */
  public static final Property ns = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code ns} property.
   * @see #ns
   */
  public String getNs() { return getString(ns); }
  
  /**
   * Set the {@code ns} property.
   * @see #ns
   */
  public void setNs(String v) { setString(ns, v, null); }

////////////////////////////////////////////////////////////////
// Property "tag"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code tag} property.
   * @see #getTag
   * @see #setTag
   */
  public static final Property tag = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code tag} property.
   * @see #tag
   */
  public String getTag() { return getString(tag); }
  
  /**
   * Set the {@code tag} property.
   * @see #tag
   */
  public void setTag(String v) { setString(tag, v, null); }

////////////////////////////////////////////////////////////////
// Property "types"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code types} property.
   * @see #getTypes
   * @see #setTypes
   */
  public static final Property types = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code types} property.
   * @see #types
   */
  public String getTypes() { return getString(types); }
  
  /**
   * Set the {@code types} property.
   * @see #types
   */
  public void setTypes(String v) { setString(types, v, null); }

////////////////////////////////////////////////////////////////
// Property "PointNames"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code PointNames} property.
   * @see #getPointNames
   * @see #setPointNames
   */
  public static final Property PointNames = newProperty(0, BString.make(""), null);
  
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
