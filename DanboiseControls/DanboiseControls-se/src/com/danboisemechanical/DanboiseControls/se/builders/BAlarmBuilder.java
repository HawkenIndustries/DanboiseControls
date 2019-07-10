package com.danboisemechanical.DanboiseControls.se.builders;

import com.danboisemechanical.DanboiseControls.se.models.enums.BAlarmTypeEnum;
import com.danboisemechanical.DanboiseControls.se.workers.BAlarmBuilderWorker;

import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;
import java.util.logging.Logger;

@NiagaraType

@NiagaraProperty(
        name = "AlarmType",
        type = "baja:Enum",
        defaultValue = "BAlarmTypeEnum.None",
        flags = Flags.SUMMARY
)

@NiagaraProperty(
        name = "AlarmWorker",
        type = "DanboiseControls:AlarmBuilderWorker",
        defaultValue = "BAlarmBuilderWorker.make()",
        flags = Flags.HIDDEN
)

@NiagaraAction(
        name = "BuildAll",
        flags = Flags.ASYNC
)
@NiagaraAction(
        name = "BuildOne",
        flags = Flags.ASYNC
)

public class BAlarmBuilder extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.builders.BAlarmBuilder(1881621854)1.0$ @*/
/* Generated Mon Jul 08 15:20:03 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "AlarmType"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code AlarmType} property.
   * @see #getAlarmType
   * @see #setAlarmType
   */
  public static final Property AlarmType = newProperty(Flags.SUMMARY, BAlarmTypeEnum.None, null);
  
  /**
   * Get the {@code AlarmType} property.
   * @see #AlarmType
   */
  public BEnum getAlarmType() { return (BEnum)get(AlarmType); }
  
  /**
   * Set the {@code AlarmType} property.
   * @see #AlarmType
   */
  public void setAlarmType(BEnum v) { set(AlarmType, v, null); }

////////////////////////////////////////////////////////////////
// Property "AlarmWorker"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code AlarmWorker} property.
   * @see #getAlarmWorker
   * @see #setAlarmWorker
   */
  public static final Property AlarmWorker = newProperty(Flags.HIDDEN, BAlarmBuilderWorker.make(), null);
  
  /**
   * Get the {@code AlarmWorker} property.
   * @see #AlarmWorker
   */
  public BAlarmBuilderWorker getAlarmWorker() { return (BAlarmBuilderWorker)get(AlarmWorker); }
  
  /**
   * Set the {@code AlarmWorker} property.
   * @see #AlarmWorker
   */
  public void setAlarmWorker(BAlarmBuilderWorker v) { set(AlarmWorker, v, null); }

////////////////////////////////////////////////////////////////
// Action "BuildAll"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code BuildAll} action.
   * @see #BuildAll()
   */
  public static final Action BuildAll = newAction(Flags.ASYNC, null);
  
  /**
   * Invoke the {@code BuildAll} action.
   * @see #BuildAll
   */
  public void BuildAll() { invoke(BuildAll, null, null); }

////////////////////////////////////////////////////////////////
// Action "BuildOne"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code BuildOne} action.
   * @see #BuildOne()
   */
  public static final Action BuildOne = newAction(Flags.ASYNC, null);
  
  /**
   * Invoke the {@code BuildOne} action.
   * @see #BuildOne
   */
  public void BuildOne() { invoke(BuildOne, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BAlarmBuilder.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  private static Logger logger = Logger.getLogger("DMI_SysBuilder_AlarmBuilder");

  public void doBuildOne(){


    switch(this.getAlarmType().getOrdinal()){
      case 0:
        break;
      case 1:
          String query = "";
        break;
      case 4:

        break;
      default:
          logger.warning("Build One - enum ordinal not found...!");
        break;
    }
  }

  public void doBuildAll(){}

  public static BAlarmBuilder make(){
      return new BAlarmBuilder();
  }

  public IFuture post(Action a, BValue arg, Context c){
      Invocation work = new Invocation (this, a , arg, c);
      this.getAlarmWorker().postWork(work);
      return null;
  }
}
