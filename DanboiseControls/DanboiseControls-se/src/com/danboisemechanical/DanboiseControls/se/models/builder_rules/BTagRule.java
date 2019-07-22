package com.danboisemechanical.DanboiseControls.se.models.builder_rules;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;

import java.util.logging.Logger;

@NiagaraType
@NiagaraProperty(
        name = "id",
        type = "baja:String",
        defaultValue = "\"\"",
        flags = Flags.SUMMARY
)
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
        name = "pointNames",
        type = "baja:String",
        defaultValue = "BString.make(\"\")"
)

public class BTagRule extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.models.builder_rules.BTagRule(1439005787)1.0$ @*/
/* Generated Sun Jul 21 20:12:24 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "id"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code id} property.
   * @see #getId
   * @see #setId
   */
  public static final Property id = newProperty(Flags.SUMMARY, "\"\"", null);
  
  /**
   * Get the {@code id} property.
   * @see #id
   */
  public String getId() { return getString(id); }
  
  /**
   * Set the {@code id} property.
   * @see #id
   */
  public void setId(String v) { setString(id, v, null); }

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
// Property "pointNames"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code pointNames} property.
   * @see #getPointNames
   * @see #setPointNames
   */
  public static final Property pointNames = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code pointNames} property.
   * @see #pointNames
   */
  public String getPointNames() { return getString(pointNames); }
  
  /**
   * Set the {@code pointNames} property.
   * @see #pointNames
   */
  public void setPointNames(String v) { setString(pointNames, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTagRule.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  private static Logger logger = Logger.getLogger("DMI_SysBuilder_TagBuilder");

  public BTagRule(){}

  public static BTagRule make(){
    return new BTagRule();
  }

}
