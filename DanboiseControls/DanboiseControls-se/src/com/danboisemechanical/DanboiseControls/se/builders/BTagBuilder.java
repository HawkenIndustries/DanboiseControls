package com.danboisemechanical.DanboiseControls.se.builders;

import com.danboisemechanical.DanboiseControls.se.models.BuilderRules.BTagRule;
import com.danboisemechanical.DanboiseControls.se.workers.BSysBuilderWorker;

import javax.baja.file.BFileSystem;
import javax.baja.file.BIFile;
import javax.baja.file.FilePath;
import javax.baja.naming.BOrd;
import javax.baja.naming.OrdQuery;
import javax.baja.naming.UnresolvedException;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.IFuture;
import javax.baja.util.Invocation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

@NiagaraType

@NiagaraProperty(
        name = "BqlQuery",
        type = "baja:String",
        defaultValue = "BString.make(\"\")",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "TagRulesOrd",
        type = "baja:Ord",
        defaultValue = "BOrd.make(\"file:^sysBuilder/BuilderRules.csv\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)
@NiagaraProperty(
        name = "RelRulesOrd",
        type = "baja:Ord",
        defaultValue = "BOrd.make(\"file:^sysBuilder/RelRules.csv\")",
        facets = {
                @Facet(name = "BFacets.TARGET_TYPE", value = "\"baja:IFile\"")
        }
)

@NiagaraProperty(
        name = "SysWorker",
        type = "DanboiseControls:SysBuilderWorker",
        defaultValue = "BSysBuilderWorker.make()",
        flags = Flags.HIDDEN
)

@NiagaraAction(
        name = "AddOne",
        parameterType = "DanboiseControls:TagRule",
        defaultValue = "BTagRule.make()",
        flags = Flags.SUMMARY | Flags.ASYNC
)

@NiagaraAction(
    name = "AddMany",
    flags = Flags.SUMMARY | Flags.ASYNC
)

@NiagaraAction(
        name = "Export",
        flags = Flags.SUMMARY | Flags.ASYNC
)

@NiagaraAction(
        name = "BuildOne",
        flags = Flags.SUMMARY
)

@NiagaraAction(
        name = "BuildMany",
        flags = Flags.SUMMARY
)

@NiagaraAction(
        name = "BuildAll",
        flags = Flags.SUMMARY
)

public class BTagBuilder extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.builders.BTagBuilder(3280023229)1.0$ @*/
/* Generated Sat Jun 15 08:44:55 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "BqlQuery"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code BqlQuery} property.
   * @see #getBqlQuery
   * @see #setBqlQuery
   */
  public static final Property BqlQuery = newProperty(Flags.SUMMARY, BString.make(""), null);
  
  /**
   * Get the {@code BqlQuery} property.
   * @see #BqlQuery
   */
  public String getBqlQuery() { return getString(BqlQuery); }
  
  /**
   * Set the {@code BqlQuery} property.
   * @see #BqlQuery
   */
  public void setBqlQuery(String v) { setString(BqlQuery, v, null); }

////////////////////////////////////////////////////////////////
// Property "TagRulesOrd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code TagRulesOrd} property.
   * @see #getTagRulesOrd
   * @see #setTagRulesOrd
   */
  public static final Property TagRulesOrd = newProperty(0, BOrd.make("file:^sysBuilder/BuilderRules.csv"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code TagRulesOrd} property.
   * @see #TagRulesOrd
   */
  public BOrd getTagRulesOrd() { return (BOrd)get(TagRulesOrd); }
  
  /**
   * Set the {@code TagRulesOrd} property.
   * @see #TagRulesOrd
   */
  public void setTagRulesOrd(BOrd v) { set(TagRulesOrd, v, null); }

////////////////////////////////////////////////////////////////
// Property "RelRulesOrd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code RelRulesOrd} property.
   * @see #getRelRulesOrd
   * @see #setRelRulesOrd
   */
  public static final Property RelRulesOrd = newProperty(0, BOrd.make("file:^sysBuilder/RelRules.csv"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
  /**
   * Get the {@code RelRulesOrd} property.
   * @see #RelRulesOrd
   */
  public BOrd getRelRulesOrd() { return (BOrd)get(RelRulesOrd); }
  
  /**
   * Set the {@code RelRulesOrd} property.
   * @see #RelRulesOrd
   */
  public void setRelRulesOrd(BOrd v) { set(RelRulesOrd, v, null); }

////////////////////////////////////////////////////////////////
// Property "SysWorker"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code SysWorker} property.
   * @see #getSysWorker
   * @see #setSysWorker
   */
  public static final Property SysWorker = newProperty(Flags.HIDDEN, BSysBuilderWorker.make(), null);
  
  /**
   * Get the {@code SysWorker} property.
   * @see #SysWorker
   */
  public BSysBuilderWorker getSysWorker() { return (BSysBuilderWorker)get(SysWorker); }
  
  /**
   * Set the {@code SysWorker} property.
   * @see #SysWorker
   */
  public void setSysWorker(BSysBuilderWorker v) { set(SysWorker, v, null); }

////////////////////////////////////////////////////////////////
// Action "AddOne"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code AddOne} action.
   * @see #AddOne(BTagRule parameter)
   */
  public static final Action AddOne = newAction(Flags.SUMMARY | Flags.ASYNC, BTagRule.make(), null);
  
  /**
   * Invoke the {@code AddOne} action.
   * @see #AddOne
   */
  public void AddOne(BTagRule parameter) { invoke(AddOne, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "AddMany"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code AddMany} action.
   * @see #AddMany()
   */
  public static final Action AddMany = newAction(Flags.SUMMARY | Flags.ASYNC, null);
  
  /**
   * Invoke the {@code AddMany} action.
   * @see #AddMany
   */
  public void AddMany() { invoke(AddMany, null, null); }

////////////////////////////////////////////////////////////////
// Action "Export"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code Export} action.
   * @see #Export()
   */
  public static final Action Export = newAction(Flags.SUMMARY | Flags.ASYNC, null);
  
  /**
   * Invoke the {@code Export} action.
   * @see #Export
   */
  public void Export() { invoke(Export, null, null); }

////////////////////////////////////////////////////////////////
// Action "BuildOne"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code BuildOne} action.
   * @see #BuildOne()
   */
  public static final Action BuildOne = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code BuildOne} action.
   * @see #BuildOne
   */
  public void BuildOne() { invoke(BuildOne, null, null); }

////////////////////////////////////////////////////////////////
// Action "BuildMany"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code BuildMany} action.
   * @see #BuildMany()
   */
  public static final Action BuildMany = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code BuildMany} action.
   * @see #BuildMany
   */
  public void BuildMany() { invoke(BuildMany, null, null); }

////////////////////////////////////////////////////////////////
// Action "BuildAll"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code BuildAll} action.
   * @see #BuildAll()
   */
  public static final Action BuildAll = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code BuildAll} action.
   * @see #BuildAll
   */
  public void BuildAll() { invoke(BuildAll, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTagBuilder.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    //PRIVATE FIELDS
    private static Logger logger = Logger.getLogger("DMI_SysBuilder_Service");

    //COMPONENT CALLBACKS
    @Override
    public void started(){
        try{
            BIFile tagFile = (BIFile)getTagRulesOrd().get(this);
            tagFile.write("".getBytes());
        }catch(UnresolvedException ue){
            OrdQuery[] qp = getTagRulesOrd().parse();
            FilePath fp = (FilePath)qp[qp.length - 1];
            try{
                BIFile file = BFileSystem.INSTANCE.makeFile(fp);
            }catch(Exception e){logger.severe(e.getMessage());}
        }
        catch(IOException ioe){
            logger.severe(ioe.getMessage());
        }
        try{
            BIFile tagFile = (BIFile)getRelRulesOrd().get(this);
            tagFile.write("".getBytes());
        }catch(UnresolvedException ue){
            OrdQuery[] qp = getRelRulesOrd().parse();
            FilePath fp = (FilePath)qp[qp.length - 1];
            try{
                BIFile file = BFileSystem.INSTANCE.makeFile(fp);
            }catch(Exception e){logger.severe(e.getMessage());}
        }
        catch(IOException ioe){
            logger.severe(ioe.getMessage());
        }
    }

    /**
    * Pass one single point name hint to the row of hints for a given system tag from any tag dictionary available.
     * Every row works to discover target points and generate tags for them, the first element of each row is the
     * tag id, then separated by a third colon ( tag id has a colon in it) is a csv series of point name hints to use
     * when looking for points that should carry the aforementioned tag id.
     * @param parameter
     * @return void
    * */

    public void doAddOne(BTagRule parameter){
//        logger.info(parameter.getPointNameHint());
//        logger.info(parameter.getTargetId());

        try{
            BIFile fileObj = (BIFile)getTagRulesOrd().get(this);
            FilePath fp = fileObj.getFilePath();
            File f = BFileSystem.INSTANCE.pathToLocalFile(fp);
            FileWriter fw = new FileWriter(f, true);
            fw.write(parameter.getTargetId()+":"+parameter.getPointNameHint()+",");
            fw.close();
        }catch(UnresolvedException ure){
            logger.severe("FILE IO = ERROR - Unresolved file ord...!!!\n"+
                    ure.getCause());
        }catch(IOException io){
            logger.severe("FILE IO ERROR - Unknown error...!!\n"+io.getCause());
        }

        // TODO: 6/15/2019 Create exception class to control input to the tagId parameter
        // TODO: 6/15/2019 Implement tag generation logic
        // TODO: 6/15/2019 Create Basic relationship builder logic to support hierarchy building 
    }

    public void doAddMany(){}

    public void doExport(){}

    public void doBuildOne(){}

    public void doBuildMany(){}

    public void doBuildAll(){}

    public static BTagBuilder make() { return new BTagBuilder(); }

    public IFuture post(Action a, BValue arg, Context c){
        Invocation work = new Invocation (this, a , arg, c);
        this.getSysWorker().postWork(work);
        return null;
    }

}
