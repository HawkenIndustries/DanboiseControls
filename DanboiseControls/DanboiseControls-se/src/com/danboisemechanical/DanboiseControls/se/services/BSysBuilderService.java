package com.danboisemechanical.DanboiseControls.se.services;

import com.danboisemechanical.DanboiseControls.se.builders.BPRNBuilder;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;
import java.util.logging.Logger;

@NiagaraProperty(
        name = "PRNBuilder",
        type = "DanboiseControls:PRNBuilder",
        defaultValue = "BPRNBuilder.make()",
        flags = Flags.SUMMARY
)


@NiagaraType

public class BSysBuilderService extends BAbstractService {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.services.BSysBuilderService(3514410439)1.0$ @*/
/* Generated Wed May 22 21:48:28 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "PRNBuilder"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code PRNBuilder} property.
   * @see #getPRNBuilder
   * @see #setPRNBuilder
   */
  public static final Property PRNBuilder = newProperty(Flags.SUMMARY, BPRNBuilder.make(), null);
  
  /**
   * Get the {@code PRNBuilder} property.
   * @see #PRNBuilder
   */
  public BPRNBuilder getPRNBuilder() { return (BPRNBuilder)get(PRNBuilder); }
  
  /**
   * Set the {@code PRNBuilder} property.
   * @see #PRNBuilder
   */
  public void setPRNBuilder(BPRNBuilder v) { set(PRNBuilder, v, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSysBuilderService.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    //PARENT METHOD OVERRIDES
    @Override
    public Type[] getServiceTypes() {
        return serviceTypes;
    }

    @Override
    public BIcon getIcon(){
        return BIcon.make("module://DanboiseControls/res/icons/dmicon.png");
    }

    //PRIVATE FIELDS
    private static Logger logger = Logger.getLogger("DMI_SysBuilder_Service");
    private static Type[] serviceTypes = new Type[]{TYPE};

    //CLASS METHODS
    /*public IFuture post(Action a, BValue arg, Context c){
        Invocation work = new Invocation(this, a, arg, c);
        getSysBuilderWorker().postWork(work);
        return null;
    }*/
}
