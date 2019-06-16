package com.danboisemechanical.DanboiseControls.se.models.alarms;

import com.danboisemechanical.DanboiseControls.se.models.enums.BAlarmTypeEnum;
import javax.baja.alarm.BAlarmTransitionBits;
import javax.baja.alarm.ext.BOffnormalAlgorithm;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BFormat;

@NiagaraType
@NiagaraProperty(
        name = "AlarmType",
        type = "smolinski:AlarmTypeEnum",
        defaultValue = "BAlarmTypeEnum.make(\"None\")",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "AlarmClass",
        type = "java:String",
        defaultValue = "AlarmLoggingClass",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "AlarmEnable",
        type = "baja:AlarmTransitionBits",
        defaultValue = "BAlarmTransitionBits.make(12)",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "TimeDelay",
        type = "baja:RelTime",
        defaultValue = "BRelTime.makeSeconds(1)",
        facets = {
                @Facet(name = "BFacets.MIN", value = "BRelTime.makeSeconds(0)"),
                @Facet(name = "BFacets.MAX", value = "BRelTime.makeSeconds(5)")
        }
)
@NiagaraProperty(
        name = "TimeDelayToNormal",
        type = "baja:RelTime",
        defaultValue = "BRelTime.makeSeconds(1)",
        facets = {
                @Facet(name = "BFacets.MIN", value = "BRelTime.makeSeconds(0)"),
                @Facet(name = "BFacets.MAX", value = "BRelTime.makeMinutes(60)"),
        }
)
public abstract class BAbstractAlarmType extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.models.alarms.BAbstractAlarmType(1728253400)1.0$ @*/
/* Generated Tue Apr 16 13:42:37 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "AlarmType"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code AlarmType} property.
   * @see #getAlarmType
   * @see #setAlarmType
   */
  public static final Property AlarmType = newProperty(Flags.SUMMARY, BAlarmTypeEnum.make("None"), null);
  
  /**
   * Get the {@code AlarmType} property.
   * @see #AlarmType
   */
  public BAlarmTypeEnum getAlarmType() { return (BAlarmTypeEnum)get(AlarmType); }
  
  /**
   * Set the {@code AlarmType} property.
   * @see #AlarmType
   */
  public void setAlarmType(BAlarmTypeEnum v) { set(AlarmType, v, null); }

////////////////////////////////////////////////////////////////
// Property "AlarmClass"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code AlarmClass} property.
   * @see #getAlarmClass
   * @see #setAlarmClass
   */
  public static final Property AlarmClass = newProperty(Flags.SUMMARY, "AlarmLoggingClass", null);
  
  /**
   * Get the {@code AlarmClass} property.
   * @see #AlarmClass
   */
  public String getAlarmClass() { return getString(AlarmClass); }
  
  /**
   * Set the {@code AlarmClass} property.
   * @see #AlarmClass
   */
  public void setAlarmClass(String v) { setString(AlarmClass, v, null); }

////////////////////////////////////////////////////////////////
// Property "AlarmEnable"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code AlarmEnable} property.
   * @see #getAlarmEnable
   * @see #setAlarmEnable
   */
  public static final Property AlarmEnable = newProperty(Flags.SUMMARY, BAlarmTransitionBits.make(12), null);
  
  /**
   * Get the {@code AlarmEnable} property.
   * @see #AlarmEnable
   */
  public BAlarmTransitionBits getAlarmEnable() { return (BAlarmTransitionBits)get(AlarmEnable); }
  
  /**
   * Set the {@code AlarmEnable} property.
   * @see #AlarmEnable
   */
  public void setAlarmEnable(BAlarmTransitionBits v) { set(AlarmEnable, v, null); }

////////////////////////////////////////////////////////////////
// Property "TimeDelay"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code TimeDelay} property.
   * @see #getTimeDelay
   * @see #setTimeDelay
   */
  public static final Property TimeDelay = newProperty(0, BRelTime.makeSeconds(1), BFacets.make(BFacets.make(BFacets.MIN, BRelTime.makeSeconds(0)), BFacets.make(BFacets.MAX, BRelTime.makeSeconds(5))));
  
  /**
   * Get the {@code TimeDelay} property.
   * @see #TimeDelay
   */
  public BRelTime getTimeDelay() { return (BRelTime)get(TimeDelay); }
  
  /**
   * Set the {@code TimeDelay} property.
   * @see #TimeDelay
   */
  public void setTimeDelay(BRelTime v) { set(TimeDelay, v, null); }

////////////////////////////////////////////////////////////////
// Property "TimeDelayToNormal"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code TimeDelayToNormal} property.
   * @see #getTimeDelayToNormal
   * @see #setTimeDelayToNormal
   */
  public static final Property TimeDelayToNormal = newProperty(0, BRelTime.makeSeconds(1), BFacets.make(BFacets.make(BFacets.MIN, BRelTime.makeSeconds(0)), BFacets.make(BFacets.MAX, BRelTime.makeMinutes(60))));
  
  /**
   * Get the {@code TimeDelayToNormal} property.
   * @see #TimeDelayToNormal
   */
  public BRelTime getTimeDelayToNormal() { return (BRelTime)get(TimeDelayToNormal); }
  
  /**
   * Set the {@code TimeDelayToNormal} property.
   * @see #TimeDelayToNormal
   */
  public void setTimeDelayToNormal(BRelTime v) { set(TimeDelayToNormal, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAbstractAlarmType.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

/***
 * @author: Victor Smolinski
 * @version:  1.0.1.0
 * @since: 2019-04-02
 * Fire alarm model class
 */

    

    /**FIELDS**/

    /**METHODS**/

    /**
     *Makes and returns the alarm's metadata
     * @param geoCode: building's geolocation code
     * @param id: alarm id code to designate multiple alarms of the same type
     * @Return BFacets
     * **/

    public abstract BFacets makeMetadata(String geoCode, String id);

    /**
     *Makes and returns the alarm's source name as a literal string of BFormat type. The method finds out if the object
     * supplied is point, and whether the proxyExt is null. If the point has a proxy, the method checks the pointExt for
     * point folders, if there are points folders, the method determines it is a N2, or gateway like integration and
     * finds the parent component of the point, provided it is a point folder type of object, the method gets the
     * display names and formats them before returning.
     * @param point: BObject, it should cast down to a controlPoint or else it will throw an exception.
     * @Return BFormat
     * **/
    public abstract BFormat makeSourceName(BObject point);
    /**
     * Receives a boolean input to determine if the message is for an active or normal alarm condition; it creates an
     * Alarm message on the calling object based on that criteria.
     * @param isActiveAlarm: Boolean, determines wheteher the message is for an active or normal alarm condition.
     * @return BFormat
     * */

    public abstract BFormat makeAlarmMsg(Boolean isActiveAlarm);

    /***
     * Makes the alarm offnormal algorithm in the caller's property sheet.
     * @return BBooleanChangeOfStateAlgorithm
     * */
    public abstract BOffnormalAlgorithm makeAlgrthm();
}
