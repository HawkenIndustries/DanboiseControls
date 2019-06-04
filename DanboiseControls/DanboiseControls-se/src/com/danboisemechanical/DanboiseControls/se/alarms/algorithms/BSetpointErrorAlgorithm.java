package com.danboisemechanical.DanboiseControls.se.alarms.algorithms;

import javax.baja.alarm.ext.BAlarmSourceExt;
import javax.baja.alarm.ext.BAlarmState;
import javax.baja.alarm.ext.BLimitEnable;
import javax.baja.alarm.ext.BOffnormalAlgorithm;
import javax.baja.control.BNumericPoint;
import javax.baja.naming.BOrd;
import javax.baja.naming.NullOrdException;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusValue;
import javax.baja.sys.*;
import javax.baja.units.BUnit;
import javax.baja.util.BFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Logger;

@NiagaraProperty(
        name = "controlSetpoint",
        type = "baja:StatusNumeric",
        defaultValue = "new BStatusNumeric(0.0)",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name = "setpointOrd",
        type = "baja:Ord",
        defaultValue = "BOrd.make(\"\")"
)

@NiagaraProperty(
        name = "highLimit",
        type = "baja:Double",
        defaultValue = "BDouble.make(4.0)"
)

@NiagaraProperty(
        name = "lowLimit",
        type = "baja:Double",
        defaultValue = "BDouble.make(4.0)"
)

@NiagaraProperty(
        name = "highDeadband",
        type = "baja:Double",
        defaultValue = "BDouble.make(2.0)"
)

@NiagaraProperty(
        name = "lowDeadband",
        type = "baja:Double",
        defaultValue = "BDouble.make(2.0)"
)

@NiagaraProperty(
        name = "highLimitText",
        type = "baja:Format",
        defaultValue = "BFormat.make(\"ZONE TEMP HI LIMIT !!\")",
        facets = {
                @Facet(name = "\"multiline\"", value = "BBoolean.TRUE")
        }
)

@NiagaraProperty(
        name = "lowLimitText",
        type = "baja:Format",
        defaultValue = "BFormat.make(\"ZONE TEMP LO LIMIT !!\")",
        facets = {
                @Facet(name = "\"multiline\"", value = "BBoolean.TRUE")
        }
)

@NiagaraProperty(
        name = "limitEnable",
        type = "alarm:LimitEnable",
        defaultValue = "new BLimitEnable()"
)

@NiagaraProperty(
        name = "lowError",
        type = "baja:Double",
        defaultValue = "BDouble.make(0)",
        flags = Flags.DEFAULT_ON_CLONE | Flags.READONLY | Flags.SUMMARY
)

@NiagaraProperty(
        name = "highError",
        type = "baja:Double",
        defaultValue = "BDouble.make(0)",
        flags = Flags.DEFAULT_ON_CLONE | Flags.READONLY | Flags.SUMMARY
)

@NiagaraProperty(
        name = "errorMsg",
        type = "baja:String",
        defaultValue = "BString.make(\"\")",
        flags = Flags.DEFAULT_ON_CLONE | Flags.READONLY | Flags.SUMMARY
)

@NiagaraType

public class BSetpointErrorAlgorithm extends BOffnormalAlgorithm {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.alarms.algorithms.BSetpointErrorAlgorithm(122731618)1.0$ @*/
/* Generated Fri May 31 07:57:19 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "controlSetpoint"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code controlSetpoint} property.
   * @see #getControlSetpoint
   * @see #setControlSetpoint
   */
  public static final Property controlSetpoint = newProperty(Flags.SUMMARY, new BStatusNumeric(0.0), null);
  
  /**
   * Get the {@code controlSetpoint} property.
   * @see #controlSetpoint
   */
  public BStatusNumeric getControlSetpoint() { return (BStatusNumeric)get(controlSetpoint); }
  
  /**
   * Set the {@code controlSetpoint} property.
   * @see #controlSetpoint
   */
  public void setControlSetpoint(BStatusNumeric v) { set(controlSetpoint, v, null); }

////////////////////////////////////////////////////////////////
// Property "setpointOrd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code setpointOrd} property.
   * @see #getSetpointOrd
   * @see #setSetpointOrd
   */
  public static final Property setpointOrd = newProperty(0, BOrd.make(""), null);
  
  /**
   * Get the {@code setpointOrd} property.
   * @see #setpointOrd
   */
  public BOrd getSetpointOrd() { return (BOrd)get(setpointOrd); }
  
  /**
   * Set the {@code setpointOrd} property.
   * @see #setpointOrd
   */
  public void setSetpointOrd(BOrd v) { set(setpointOrd, v, null); }

////////////////////////////////////////////////////////////////
// Property "highLimit"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code highLimit} property.
   * @see #getHighLimit
   * @see #setHighLimit
   */
  public static final Property highLimit = newProperty(0, ((BDouble)(BDouble.make(4.0))).getDouble(), null);
  
  /**
   * Get the {@code highLimit} property.
   * @see #highLimit
   */
  public double getHighLimit() { return getDouble(highLimit); }
  
  /**
   * Set the {@code highLimit} property.
   * @see #highLimit
   */
  public void setHighLimit(double v) { setDouble(highLimit, v, null); }

////////////////////////////////////////////////////////////////
// Property "lowLimit"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code lowLimit} property.
   * @see #getLowLimit
   * @see #setLowLimit
   */
  public static final Property lowLimit = newProperty(0, ((BDouble)(BDouble.make(4.0))).getDouble(), null);
  
  /**
   * Get the {@code lowLimit} property.
   * @see #lowLimit
   */
  public double getLowLimit() { return getDouble(lowLimit); }
  
  /**
   * Set the {@code lowLimit} property.
   * @see #lowLimit
   */
  public void setLowLimit(double v) { setDouble(lowLimit, v, null); }

////////////////////////////////////////////////////////////////
// Property "highDeadband"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code highDeadband} property.
   * @see #getHighDeadband
   * @see #setHighDeadband
   */
  public static final Property highDeadband = newProperty(0, ((BDouble)(BDouble.make(2.0))).getDouble(), null);
  
  /**
   * Get the {@code highDeadband} property.
   * @see #highDeadband
   */
  public double getHighDeadband() { return getDouble(highDeadband); }
  
  /**
   * Set the {@code highDeadband} property.
   * @see #highDeadband
   */
  public void setHighDeadband(double v) { setDouble(highDeadband, v, null); }

////////////////////////////////////////////////////////////////
// Property "lowDeadband"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code lowDeadband} property.
   * @see #getLowDeadband
   * @see #setLowDeadband
   */
  public static final Property lowDeadband = newProperty(0, ((BDouble)(BDouble.make(2.0))).getDouble(), null);
  
  /**
   * Get the {@code lowDeadband} property.
   * @see #lowDeadband
   */
  public double getLowDeadband() { return getDouble(lowDeadband); }
  
  /**
   * Set the {@code lowDeadband} property.
   * @see #lowDeadband
   */
  public void setLowDeadband(double v) { setDouble(lowDeadband, v, null); }

////////////////////////////////////////////////////////////////
// Property "highLimitText"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code highLimitText} property.
   * @see #getHighLimitText
   * @see #setHighLimitText
   */
  public static final Property highLimitText = newProperty(0, BFormat.make("ZONE TEMP HI LIMIT !!"), BFacets.make("multiline", BBoolean.TRUE));
  
  /**
   * Get the {@code highLimitText} property.
   * @see #highLimitText
   */
  public BFormat getHighLimitText() { return (BFormat)get(highLimitText); }
  
  /**
   * Set the {@code highLimitText} property.
   * @see #highLimitText
   */
  public void setHighLimitText(BFormat v) { set(highLimitText, v, null); }

////////////////////////////////////////////////////////////////
// Property "lowLimitText"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code lowLimitText} property.
   * @see #getLowLimitText
   * @see #setLowLimitText
   */
  public static final Property lowLimitText = newProperty(0, BFormat.make("ZONE TEMP LO LIMIT !!"), BFacets.make("multiline", BBoolean.TRUE));
  
  /**
   * Get the {@code lowLimitText} property.
   * @see #lowLimitText
   */
  public BFormat getLowLimitText() { return (BFormat)get(lowLimitText); }
  
  /**
   * Set the {@code lowLimitText} property.
   * @see #lowLimitText
   */
  public void setLowLimitText(BFormat v) { set(lowLimitText, v, null); }

////////////////////////////////////////////////////////////////
// Property "limitEnable"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code limitEnable} property.
   * @see #getLimitEnable
   * @see #setLimitEnable
   */
  public static final Property limitEnable = newProperty(0, new BLimitEnable(), null);
  
  /**
   * Get the {@code limitEnable} property.
   * @see #limitEnable
   */
  public BLimitEnable getLimitEnable() { return (BLimitEnable)get(limitEnable); }
  
  /**
   * Set the {@code limitEnable} property.
   * @see #limitEnable
   */
  public void setLimitEnable(BLimitEnable v) { set(limitEnable, v, null); }

////////////////////////////////////////////////////////////////
// Property "lowError"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code lowError} property.
   * @see #getLowError
   * @see #setLowError
   */
  public static final Property lowError = newProperty(Flags.DEFAULT_ON_CLONE | Flags.READONLY | Flags.SUMMARY, ((BDouble)(BDouble.make(0))).getDouble(), null);
  
  /**
   * Get the {@code lowError} property.
   * @see #lowError
   */
  public double getLowError() { return getDouble(lowError); }
  
  /**
   * Set the {@code lowError} property.
   * @see #lowError
   */
  public void setLowError(double v) { setDouble(lowError, v, null); }

////////////////////////////////////////////////////////////////
// Property "highError"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code highError} property.
   * @see #getHighError
   * @see #setHighError
   */
  public static final Property highError = newProperty(Flags.DEFAULT_ON_CLONE | Flags.READONLY | Flags.SUMMARY, ((BDouble)(BDouble.make(0))).getDouble(), null);
  
  /**
   * Get the {@code highError} property.
   * @see #highError
   */
  public double getHighError() { return getDouble(highError); }
  
  /**
   * Set the {@code highError} property.
   * @see #highError
   */
  public void setHighError(double v) { setDouble(highError, v, null); }

////////////////////////////////////////////////////////////////
// Property "errorMsg"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code errorMsg} property.
   * @see #getErrorMsg
   * @see #setErrorMsg
   */
  public static final Property errorMsg = newProperty(Flags.DEFAULT_ON_CLONE | Flags.READONLY | Flags.SUMMARY, BString.make(""), null);
  
  /**
   * Get the {@code errorMsg} property.
   * @see #errorMsg
   */
  public String getErrorMsg() { return getString(errorMsg); }
  
  /**
   * Set the {@code errorMsg} property.
   * @see #errorMsg
   */
  public void setErrorMsg(String v) { setString(errorMsg, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSetpointErrorAlgorithm.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  //INITIALIZE STATE MACHINE
  BSetpointErrorAlgorithm.OutOfRangeState current = new NormalState();

  //CONSTRUCTORS
  public BSetpointErrorAlgorithm(){
  }

  //PUBLIC METHODS
  public static BSetpointErrorAlgorithm make(){
    return new BSetpointErrorAlgorithm();
  }

  //PRIVATE FIELDS
  private static Logger logger = Logger.getLogger("DMI_Alarms");

  //PRIVATE METHODS
  private boolean isHighLimitEnabled() {
    return this.getLimitEnable().isHighLimitEnabled();
  }
  private boolean isLowLimitEnabled() {
    return this.getLimitEnable().isLowLimitEnabled();
  }

  void transition(OutOfRangeState state) {
    this.current = state;
  }

  private void tryLink(BStatusNumeric out){
    BComponent c = out.getParentComponent();
    boolean isLinked = false;
    Property[] dyProps = c.getDynamicPropertiesArray();
    try{
      for(int i =0; i < dyProps.length; i++){
        if(dyProps[i].getName().equals("spLink")) isLinked = true;
      }
      if(!isLinked){
        BLink spLink = new BLink(c, c.getSlot("out"), this.getSlot("controlSetpoint"));
        this.add("spLink", spLink);
        spLink.activate();
      }}catch(NoSuchSlotException nsse){
        logger.severe("[ERROR] tryLink did not work because either the controlSetpoint slot or the out slot werent found...!!\n");
        nsse.printStackTrace();
    }catch(Exception e ){
        logger.severe("[ERROR] tryLink did not work, unknown error...!");
        e.printStackTrace();
    }
  }

  private void resolveSp(double pv, String msg){

    try{
      BStatusNumeric setpoint = (BStatusNumeric) getSetpointOrd().get();
      double sp = setpoint.getNumeric();
      setLowError(sp - pv);
      setHighError(pv - sp);
      tryLink(setpoint);
      setErrorMsg(msg);

    }catch(NullOrdException noe){
      logger.severe("[ERROR] Control Setpoint -> ORD Unresolved\n"+noe.getCause());
      setHighError(0);
      setLowError(0);
      setErrorMsg("Setpoint Value Binding ERROR..noe...!!");
    }catch(ClassCastException cce){
      logger.severe("[ERROR] Control Setpoint -> Illegal Class Cast\n"+cce.getCause());
      setHighError(0);
      setLowError(0);
      setErrorMsg("Setpoint Value Binding ERROR...cce...!!");
    }catch(NoSuchSlotException nsse){
      logger.severe("[ERROR] Control Setpoint -> Cant find the out property, make sure the slot path is scoped to the out property of the Numeric point...!\n"+
              nsse.getCause());
      setHighError(0);
      setLowError(0);
      setErrorMsg("Setpoint Value Binding ERROR...nsse...!!");
    }
  }

  //COMPONENT CALLBACKS
  @Override
  public void started() {

    try{
      BStatusNumeric setpoint = (BStatusNumeric) getSetpointOrd().get();
      setControlSetpoint(setpoint);
      setErrorMsg("Starting...");

    }catch(NullOrdException noe){
      logger.severe("[ERROR] Control Setpoint -> ORD Unresolved\n"+noe.getCause());
      setErrorMsg("Extension Un-initialized...!!");
    }catch(ClassCastException cce){
      logger.severe("[ERROR] Control Setpoint Ilegal -> Class Cast\n"+cce.getCause());
      setErrorMsg("Setpoint Value Binding ERROR...cce...!!");
    }catch(NoSuchSlotException nsse){
      logger.severe("[ERROR] Control Setpoint -> Cant find the out property\n"+nsse.getCause());
      setErrorMsg("Setpoint Value Binding ERROR...nsse...!!");
    }
    BAlarmState currentState = ((BAlarmSourceExt)this.getParent()).getAlarmState();

    if (currentState == BAlarmState.highLimit) {
      this.current = new BSetpointErrorAlgorithm.HighAlarmState();
    }

    if (currentState == BAlarmState.lowLimit) {
      this.current = new BSetpointErrorAlgorithm.LowAlarmState();
    }
  }

  @Override
  public void atSteadyState(){

    try{
      BStatusNumeric setpoint = (BStatusNumeric) getSetpointOrd().get();
      setControlSetpoint(setpoint);
      tryLink(setpoint);
      setErrorMsg("Running...");

    }catch(NullOrdException noe){
      logger.severe("[ERROR] Control Setpoint -> ORD Unresolved\n"+noe.getCause());
      setErrorMsg("Extension Un-initialized...!!");
    }catch(ClassCastException cce){
      logger.severe("[ERROR] Control Setpoint Ilegal -> Class Cast\n"+cce.getCause());
      setErrorMsg("Setpoint Value Binding ERROR...cce...!!");
    }catch(NoSuchSlotException nsse){
      logger.severe("[ERROR] Control Setpoint -> Cant find the out property\n"+nsse.getCause());
      setErrorMsg("Setpoint Value Binding ERROR...nsse...!!");
    }
  }

  @Override
  public void changed(Property p, Context cx) {
    super.changed(p, cx);
    if (this.isRunning()) {
      this.executePoint();
    }
  }

  //PARENT METHOD OVERRIDES
  public boolean isGrandparentLegal(BComponent grandparent) {
    return grandparent instanceof BNumericPoint;
  }

  public BFacets getSlotFacets(Slot slot) {
    if (slot != highLimit && slot != lowLimit) {
      if (slot == highDeadband || slot == lowDeadband) {
        BFacets facets = this.getPointFacets();
        BUnit unit = (BUnit)facets.getFacet("units");
        if (unit != null) {
          facets = BFacets.make(facets, "units", unit.getDifferentialUnit());
        }

        return BFacets.make(facets, super.getSlotFacets(highDeadband));
      } else {
        return super.getSlotFacets(slot);
      }
    } else {
      return this.getPointFacets();
    }
  }

  public BAlarmState checkAlarms(BStatusValue o, long toAlarmTimeDelay, long toNormalTimeDelay) {
    BStatusNumeric out = (BStatusNumeric)o;
    if (out.getStatus().isNull()) {
      if (this.current instanceof NormalState) {
        return null;
      } else {
        if (toNormalTimeDelay > 0L && this.current instanceof HighAlarmState) {
          this.current = new ValidateReturnFromHighState(toNormalTimeDelay);
        } else {
          if (toNormalTimeDelay <= 0L || !(this.current instanceof LowAlarmState)) {
            this.current = new NormalState();
            return BAlarmState.normal;
          }

          this.current = new ValidateReturnFromLowState(toNormalTimeDelay);
        }

        return null;
      }
    } else {
      return this.evaluate(out.getValue(), toAlarmTimeDelay, toNormalTimeDelay);
    }
  }

  private BAlarmState evaluate(double presentValue, long toAlarmTimeDelay, long toNormalTimeDelay) {
    BAlarmState currentState = ((BAlarmSourceExt)this.getParent()).getAlarmState();
    if (!(this.current instanceof ValidationState)) {
      if (currentState == BAlarmState.highLimit) {
        this.current = new HighAlarmState();
      } else if (currentState == BAlarmState.lowLimit) {
        this.current = new LowAlarmState();
      } else {
        this.current = new NormalState();
      }
    }
    return this.current.evaluate(presentValue, toAlarmTimeDelay, toNormalTimeDelay);
  }

  public void writeAlarmData(BStatusValue out, Map map) {
    BFacets facets = this.getPointFacets();
    map.put("status", BString.make(out.getStatus().toString((Context)null)));
    map.put("controlSetpoint", BString.make(BDouble.toString(getControlSetpoint().getNumeric(), facets)));
    if (this.current instanceof HighAlarmState) {
      if (!this.getHighLimitText().equals(BFormat.DEFAULT)) {
        map.put("msgText", BString.make(this.getHighLimitText().getFormat()));
      }
      map.put("highDeadband", BString.make(BDouble.toString(this.getHighDeadband(), facets)));
      map.put("highLimit", BString.make(BDouble.toString(this.getHighLimit(), facets)));
      if (this.isLowLimitEnabled()) {
        map.put("lowLimit", BString.make(BDouble.toString(this.getLowLimit(), facets)));
      }
    } else if (this.current instanceof LowAlarmState) {
      if (!this.getLowLimitText().equals(BFormat.DEFAULT)) {
        map.put("msgText", BString.make(this.getLowLimitText().getFormat()));
      }

      if (this.isHighLimitEnabled()) {
        map.put("highLimit", BString.make(BDouble.toString(this.getHighLimit(), facets)));
      }

      map.put("lowDeadband", BString.make(BDouble.toString(this.getLowDeadband(), facets)));
      map.put("lowLimit", BString.make(BDouble.toString(this.getLowLimit(), facets)));
    }

  }

  //PRIVATE INNER CLASSES
    //STATE TRANSITION CLASSES
  private abstract class ValidationState extends OutOfRangeState {
    private ValidationState() {
      super();
    }
  }

  private class ValidateLowAlarmState extends ValidationState {
    public ValidateLowAlarmState(long timeDelay) {
      super();
      BSetpointErrorAlgorithm.this.startTimer(timeDelay);
    }

    public String tag() {
      return "ValidateLowAlarmState";
    }

    public BAlarmState evaluate(double presentValue, long toAlarmTimeDelay, long toNormalTimeDelay) {

      resolveSp(presentValue, tag());
      if(getLowError() > getLowLimit() && isLowLimitEnabled()){
        if(BSetpointErrorAlgorithm.this.isTimerExpired()){
          transition(new LowAlarmState());
          return BAlarmState.lowLimit;
        }
      }else if(getHighError() > getHighLimit() && isHighLimitEnabled()){
        if(toAlarmTimeDelay == 0L){
          transition(new HighAlarmState());
          return BAlarmState.highLimit;
        }

        transition(new ValidateHighAlarmState(toAlarmTimeDelay));
      } else if(getLowError() < (getLowLimit() - getLowDeadband())){
        transition(new NormalState());
      }

      return null;
    }
  }

  private class ValidateHighAlarmState extends ValidationState {
    public ValidateHighAlarmState(long timeDelay) {
      super();
      BSetpointErrorAlgorithm.this.startTimer(timeDelay);
    }

    public String tag() {
      return "ValidateHighAlarmState";
    }

    public BAlarmState evaluate(double presentValue, long toAlarmTimeDelay, long toNormalTimeDelay) {

      resolveSp(presentValue, tag());
      if(getLowError() > getLowLimit() && isLowLimitEnabled()){
        if(toAlarmTimeDelay == 0L){
          transition(new LowAlarmState());
          return BAlarmState.lowLimit;
        }
        transition(new ValidateLowAlarmState(toAlarmTimeDelay));

      } else if(getHighError() > getHighLimit() && isHighLimitEnabled()){
        if(BSetpointErrorAlgorithm.this.isTimerExpired()){
          transition(new HighAlarmState());
          return BAlarmState.highLimit;
        }
      } else if(getHighError() < (getHighLimit() - getHighDeadband())){
        transition(new NormalState());
      }
      return null;
    }
  }

  private class ValidateReturnFromLowState extends ValidationState {
    public ValidateReturnFromLowState(long timeDelay) {
      super();
      BSetpointErrorAlgorithm.this.startTimer(timeDelay);
    }

    public String tag() {
      return "ValidateReturnFromLowState";
    }

    public BAlarmState evaluate(double presentValue, long toAlarmTimeDelay, long toNormalTimeDelay){
      resolveSp(presentValue, tag());
      if(getLowError() > getLowLimit() &&
              isLowLimitEnabled()){
        transition(new LowAlarmState());

      }else if(getLowError() < (getLowLimit() - getLowDeadband()) &&
              isTimerExpired()){
        transition(new NormalState());
        return BAlarmState.normal;
      }
      return null;
    }
  }

  private class ValidateReturnFromHighState extends ValidationState {
    public ValidateReturnFromHighState(long timeDelay) {
      super();
      BSetpointErrorAlgorithm.this.startTimer(timeDelay);
    }

    public String tag() {
      return "ValidateReturnFromHighState";
    }

    public BAlarmState evaluate(double presentValue, long toAlarmTimeDelay, long toNormalTimeDelay) {
      if (toNormalTimeDelay > 0L && !BSetpointErrorAlgorithm.this.isTimerExpired()) {
        return null;
      } else {
        if(getHighError() > getHighLimit() && isHighLimitEnabled()){
          transition(new HighAlarmState());

        } else if(getHighError() < (getHighLimit() - getHighDeadband()) &&
                BSetpointErrorAlgorithm.this.isTimerExpired()){
          transition(new NormalState());
          return BAlarmState.normal;
        }

        return null;
      }
    }
  }

    //STATE MODEL CLASSES
  private abstract class OutOfRangeState {
    public OutOfRangeState() {
      BSetpointErrorAlgorithm.this.cancelTimer();
    }

    public abstract String tag();

    public abstract BAlarmState evaluate(double var1, long var3, long var5);
  }

  private class NormalState extends OutOfRangeState {

    public NormalState() {
      super();
    }
    public String tag() {
      return "Normal";
    }

    public BAlarmState evaluate(double presentValue, long toAlarmTimeDelay, long toNormalTimeDelay) {

      resolveSp(presentValue, tag());
      if((getLowError() > getLowLimit() && getHighError() < (getHighLimit() - getHighDeadband()))
              && isLowLimitEnabled()){
        if(toAlarmTimeDelay == 0L){
          transition(new LowAlarmState());
          return BAlarmState.lowLimit;
        }
        new ValidateLowAlarmState(toAlarmTimeDelay);

      }else if((getLowError() > getLowLimit() || getHighError() > getHighLimit()) &&
                  getHighError() > getHighLimit() &&
                  isHighLimitEnabled()){
        if (toAlarmTimeDelay == 0L) {
          transition(new HighAlarmState());
          return BAlarmState.highLimit;
        }
        new ValidateHighAlarmState(toAlarmTimeDelay);
      }
      return null;
    }
  }

  private class LowAlarmState extends OutOfRangeState {

    public LowAlarmState() {
      super();
    }
    public String tag() {
      return "LowAlarmState";
    }

    public BAlarmState evaluate(double presentValue, long toAlarmTimeDelay, long toNormalTimeDelay) {

      resolveSp(presentValue, tag());
      if(!isLowLimitEnabled()){
        return BAlarmState.normal;

      }else if(getHighError() > getHighLimit() && isHighLimitEnabled()) {
        if(toNormalTimeDelay == 0L){
          transition(new NormalState());
          return BAlarmState.normal;
        }
        transition(new ValidateReturnFromLowState(toNormalTimeDelay));

      }else if(getLowError() < (getLowLimit() - getLowDeadband())){
        if(toNormalTimeDelay == 0L){
          transition(new NormalState());
          return BAlarmState.normal;
        }
        transition(new ValidateReturnFromLowState(toNormalTimeDelay));
      }
      return null;
    }
  }

  private class HighAlarmState extends OutOfRangeState {
    public HighAlarmState() {
      super();
    }

    public String tag() {
      return "HighAlarmState";
    }

    public BAlarmState evaluate(double presentValue, long toAlarmTimeDelay, long toNormalTimeDelay) {

      resolveSp(presentValue, tag());
      if(!isHighLimitEnabled()){
        return BAlarmState.normal;

      }else if(getLowError() > getLowLimit() && isLowLimitEnabled()){
        if(toAlarmTimeDelay == 0L){
          transition(new NormalState());
          return BAlarmState.normal;
        }
        transition(new ValidateReturnFromHighState(toAlarmTimeDelay));

      }else if(getHighError() < (getHighLimit() - getHighDeadband())){
        if (toNormalTimeDelay == 0L) {
          BSetpointErrorAlgorithm.this.transition(BSetpointErrorAlgorithm.this.new NormalState());
          return BAlarmState.normal;
        }
        transition(new ValidateReturnFromHighState(toNormalTimeDelay));
      }
      return null;
    }
  }
}
