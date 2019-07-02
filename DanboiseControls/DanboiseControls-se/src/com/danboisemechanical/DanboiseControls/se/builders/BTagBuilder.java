package com.danboisemechanical.DanboiseControls.se.builders;

import com.danboisemechanical.DanboiseControls.se.models.BuilderRules.BTagRule;
import com.danboisemechanical.DanboiseControls.se.utils.general.Resolver;
import com.danboisemechanical.DanboiseControls.se.workers.BSysBuilderWorker;

import com.google.gson.*;

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
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

@NiagaraType

@NiagaraProperty(
        name = "QueryPath",
        type = "baja:Ord",
        defaultValue = "BOrd.make(\"\")",
        flags = Flags.SUMMARY
)
@NiagaraProperty(
        name = "TagRulesOrd",
        type = "baja:Ord",
        defaultValue = "BOrd.make(\"file:^sysBuilder/TagRules.json\")",
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
        name = "AddRule",
        parameterType = "DanboiseControls:TagRule",
        defaultValue = "BTagRule.make()",
        flags = Flags.SUMMARY | Flags.ASYNC
)

@NiagaraAction(
        name = "BuildAll",
        flags = Flags.SUMMARY | Flags.ASYNC
)

@NiagaraAction(
        name = "MakeDoc",
        flags = Flags.SUMMARY
)

@NiagaraAction(
        name = "ReadDoc",
        flags = Flags.SUMMARY | Flags.ASYNC
)

public class BTagBuilder extends BComponent {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.builders.BTagBuilder(799414114)1.0$ @*/
/* Generated Mon Jul 01 15:18:40 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "QueryPath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code QueryPath} property.
   * @see #getQueryPath
   * @see #setQueryPath
   */
  public static final Property QueryPath = newProperty(Flags.SUMMARY, BOrd.make(""), null);
  
  /**
   * Get the {@code QueryPath} property.
   * @see #QueryPath
   */
  public BOrd getQueryPath() { return (BOrd)get(QueryPath); }
  
  /**
   * Set the {@code QueryPath} property.
   * @see #QueryPath
   */
  public void setQueryPath(BOrd v) { set(QueryPath, v, null); }

////////////////////////////////////////////////////////////////
// Property "TagRulesOrd"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code TagRulesOrd} property.
   * @see #getTagRulesOrd
   * @see #setTagRulesOrd
   */
  public static final Property TagRulesOrd = newProperty(0, BOrd.make("file:^sysBuilder/TagRules.json"), BFacets.make(BFacets.TARGET_TYPE, "baja:IFile"));
  
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
// Action "AddRule"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code AddRule} action.
   * @see #AddRule(BTagRule parameter)
   */
  public static final Action AddRule = newAction(Flags.SUMMARY | Flags.ASYNC, BTagRule.make(), null);
  
  /**
   * Invoke the {@code AddRule} action.
   * @see #AddRule
   */
  public void AddRule(BTagRule parameter) { invoke(AddRule, parameter, null); }

////////////////////////////////////////////////////////////////
// Action "BuildAll"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code BuildAll} action.
   * @see #BuildAll()
   */
  public static final Action BuildAll = newAction(Flags.SUMMARY | Flags.ASYNC, null);
  
  /**
   * Invoke the {@code BuildAll} action.
   * @see #BuildAll
   */
  public void BuildAll() { invoke(BuildAll, null, null); }

////////////////////////////////////////////////////////////////
// Action "MakeDoc"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code MakeDoc} action.
   * @see #MakeDoc()
   */
  public static final Action MakeDoc = newAction(Flags.SUMMARY, null);
  
  /**
   * Invoke the {@code MakeDoc} action.
   * @see #MakeDoc
   */
  public void MakeDoc() { invoke(MakeDoc, null, null); }

////////////////////////////////////////////////////////////////
// Action "ReadDoc"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code ReadDoc} action.
   * @see #ReadDoc()
   */
  public static final Action ReadDoc = newAction(Flags.SUMMARY | Flags.ASYNC, null);
  
  /**
   * Invoke the {@code ReadDoc} action.
   * @see #ReadDoc
   */
  public void ReadDoc() { invoke(ReadDoc, null, null); }

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////
  
  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTagBuilder.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

    //PRIVATE FIELDS
    private static Logger logger = Logger.getLogger("DMI_SysBuilder_TagBuilder");
    private Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    private JsonObject RulesDoc = new JsonObject();

    //COMPONENT CALLBACKS
    @Override
    public void started(){

        BOrd fileOrd = getTagRulesOrd();
        try{
            BIFile file = (BIFile)fileOrd.get(this);
            file.read();
        }catch(UnresolvedException ue){
            logger.warning("File ORD Unresolved: \n"+
                    ue.getCause());
            OrdQuery[] qps = fileOrd.parse();
            FilePath fp = (FilePath)qps[qps.length-1];
            try{
                BIFile file = BFileSystem.INSTANCE.makeFile(fp);
                file.write("Log start: ".concat(
                        BAbsTime.now().encodeToString()).getBytes());
            }
            catch(IOException ioe){ logger.severe("File IO Error - Couldn't make the file: \n"+
                    ioe.getCause());}

        }catch(IOException io){
            logger.severe("File IO Error: "+io.getCause());
        }

        //TODO: Deserialize into collection of BTagRule components and add to BTagBuilder as DynamicProperties

    }

    /**
     *
     * @param
     * @return void
     * */

    public void doMakeDoc(){

        AccessController.doPrivileged((PrivilegedAction<Void>)() -> {
            try{
                RulesDoc.add("rules", new JsonArray());
                logger.info(gson.toJson(RulesDoc));
                FileWriter fw = tagFileWriter();
                fw.write(gson.toJson(RulesDoc));
                fw.close();

            }catch(Exception io){ io.getMessage(); io.printStackTrace(); }
            return null;
        });
    }

    /**
     *
     * @param
     * @return void
     * */

    public void doReadDoc(){
        AccessController.doPrivileged((PrivilegedAction<Void>)() -> {
            RulesDoc = this.getRulesDoc(getTagRulesOrd());
            logger.info("Rules Json Document ("+RulesDoc.size()
                    +"):\n"+gson.toJson(RulesDoc));
            for (String s : RulesDoc.keySet()) {
                logger.info(s);
            }
            RulesDoc.keySet().forEach( e -> {
                JsonElement element = RulesDoc.get(e);
                logger.info(e);
                logger.info("JSON ARRAY: "+element.isJsonArray());
                logger.info("JSON OBJECT: "+element.isJsonObject());
                logger.info("JSON OBJECT: "+element.isJsonPrimitive());
                logger.info("JSON OBJECT: "+element.isJsonNull());
            });
            return null;
        });
    }

    /**
     *
     * @param parameter
     * @return void
    * */

    public void doAddRule(BTagRule parameter){
        AccessController.doPrivileged((PrivilegedAction<Void>)() -> {
            JsonObject rule = new JsonObject();
            JsonArray names = new JsonArray();

            Arrays.stream(parameter.getPointNames().split(","))
                    .forEach(e -> names.add(e));

            rule.addProperty("id", parameter.getTargetId());
            rule.addProperty("type", parameter.getNiagaraType());
            rule.add("names", names);
            RulesDoc.getAsJsonArray("rules").add(rule);
            logger.info(gson.toJson(RulesDoc));

            try{
                FileWriter fw = tagFileWriter();
                fw.write(gson.toJson(RulesDoc));
                fw.close();
            }catch(IOException ioe){ioe.getMessage(); ioe.printStackTrace();}

            return null;
        });
    }

    /**
     *
     * @param
     * @return void
     * */

    public void doBuildAll(){
//            local:|fox:|station:|slot:/Drivers/JciN2Network|bql:select name from control:ControlPoint where name like '*T' and type like 'control:NumericPoint'
        try{
            //TODO: Check the Rules json array to see if it has rules, if it does loop through all the points adding tags as per the rules.

            Resolver resolver = new Resolver();

            AccessController.doPrivileged((PrivilegedAction<Void>)() -> {
                RulesDoc = getRulesDoc(getTagRulesOrd());
                JsonArray rules = RulesDoc.getAsJsonArray("rules");

                rules.forEach( rule -> {
                    if(rule.isJsonObject()){

                        try{
                            JsonArray names = null;
                            String id = null;
                            String type = null;
                            String path = getQueryPath().encodeToString();
                            String bqlStart = "|bql:select name from control:ControlPoint where name like \'";
                            String bqlMed = "\' and type like \'";
                            String bqlEnd = "\'";

                            for(String e: rule.getAsJsonObject().keySet()){
                                JsonElement prop = rule.getAsJsonObject().get(e);

                                if(e.equals("id") && prop.isJsonPrimitive()){
                                    id = prop.getAsString();
                                }else if(e.equals("type") && prop.isJsonPrimitive()){
                                    type = prop.getAsString();
                                }else if(e.equals("names") && prop.isJsonArray()){
                                    names = prop.getAsJsonArray();
                                }else{
                                    logger.warning("TagBuilder - BuildAll...rule property type unknown...!");
                                }
                            }

                            for(JsonElement el: names){
                                String name = el.getAsString();
                                String bql = path.concat(bqlStart + name).concat(bqlMed + type).concat(bqlEnd);
                                ArrayList<BComponent> queryObjects = resolver.resolve(BString.make( bql ));
                                logger.info(bql);

                                for (BComponent obj : queryObjects) {
                                    logger.info(obj.getName());
                                    logger.info(obj.getSlotPath().toString());
                                }
                            }

                        }catch(UnresolvedException ue){logger.severe(ue.getMessage()); ue.printStackTrace();}
                    }else{
                        logger.warning("TagBuilder Rule is not a valid JSON object...!");
                    }
                });
                return null;
            });
        }catch(Exception e){
            logger.severe(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Static Factory Method for creating TagBuilders...
     * @param
     * @return BTagBuilder
     * */

    public static BTagBuilder make() { return new BTagBuilder(); }

    /**
     * Method for extracting the rule set stored in a local JSON file
     * @return JsonArray
     * */

    private JsonObject getRulesDoc(BOrd fileOrd){

        JsonObject json = null;
        try{
            BIFile tagFile = (BIFile)fileOrd.get(this);
            String src = new String(tagFile.read());

            json = AccessController.doPrivileged((PrivilegedAction<JsonObject>)() -> {

                JsonObject doc = new JsonObject();
                try{
                    doc = gson.fromJson(src, JsonObject.class);
                }catch(Exception RulesDocException){
                    logger.severe(RulesDocException.getMessage());
                }
                return doc;
            });
        }catch(IOException ioe){
            logger.severe(ioe.getMessage());
        }
        return json;
    }

    /**
     * We want to make sure the rules document is not empty, and it contains a JSON array of rule objects.
     * This method doesn't have privileged code access so it must be run called from one that does...!
     * @param
     * @return boolean
     * */

    private FileWriter tagFileWriter(){
        try{
            BIFile fileObj = (BIFile)getTagRulesOrd().get(this);
            FilePath fp = fileObj.getFilePath();
            File f = BFileSystem.INSTANCE.pathToLocalFile(fp);
            FileWriter fw = new FileWriter(f);
            return fw;
        }catch(UnresolvedException ure){
            logger.severe("FILE IO = ERROR - Unresolved file ord...!!!\n"+
                    ure.getMessage());
        }catch(IOException io){
            logger.severe("FILE IO ERROR - Unknown error...!!\n"+io.getMessage());
        }catch(Exception e){ logger.severe("UNKOWN EXCEPTION...!!\t"+e.getMessage()); }

        return null;
    }

    public IFuture post(Action a, BValue arg, Context c){
        Invocation work = new Invocation (this, a , arg, c);
        this.getSysWorker().postWork(work);
        return null;
    }


}