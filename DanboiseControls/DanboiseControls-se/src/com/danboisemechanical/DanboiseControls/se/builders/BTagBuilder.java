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
import javax.baja.naming.SlotPath;
import javax.baja.naming.UnresolvedException;
import javax.baja.nre.annotations.Facet;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.tag.Id;
import javax.baja.tag.Tag;
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
        defaultValue = "BOrd.make(\"\")"
)
@NiagaraProperty(
        name = "QueryBaseType",
        type = "baja:String",
        defaultValue = "BString.make(\"\")"
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
/*@ $com.danboisemechanical.DanboiseControls.se.builders.BTagBuilder(1731170166)1.0$ @*/
/* Generated Tue Jul 02 13:20:34 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Property "QueryPath"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code QueryPath} property.
   * @see #getQueryPath
   * @see #setQueryPath
   */
  public static final Property QueryPath = newProperty(0, BOrd.make(""), null);
  
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
// Property "QueryBaseType"
////////////////////////////////////////////////////////////////
  
  /**
   * Slot for the {@code QueryBaseType} property.
   * @see #getQueryBaseType
   * @see #setQueryBaseType
   */
  public static final Property QueryBaseType = newProperty(0, BString.make(""), null);
  
  /**
   * Get the {@code QueryBaseType} property.
   * @see #QueryBaseType
   */
  public String getQueryBaseType() { return getString(QueryBaseType); }
  
  /**
   * Set the {@code QueryBaseType} property.
   * @see #QueryBaseType
   */
  public void setQueryBaseType(String v) { setString(QueryBaseType, v, null); }

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
            JsonArray types = new JsonArray();
            JsonArray names = new JsonArray();

            Arrays.stream(parameter.getPointNames().split(","))
                    .forEach(e -> names.add(e));

            rule.addProperty("ns", parameter.getNs());
            rule.addProperty("tag", parameter.getTag());
            if(parameter.getTypes().contains(",")){
                Arrays.stream(parameter.getTypes().split(","))
                        .forEach( e -> types.add(e));
                rule.add("types", types);
            }else if(parameter.getTypes().isEmpty()){
                rule.add("types", types);
            }
            else{
                types.add(parameter.getTypes());
                rule.add("types", types);
            }
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
        try{

            Resolver resolver = new Resolver();

            AccessController.doPrivileged((PrivilegedAction<Void>)() -> {
                RulesDoc = getRulesDoc(getTagRulesOrd());
                JsonArray rules = RulesDoc.getAsJsonArray("rules");

                rules.forEach( rule -> {
                    if(rule.isJsonObject()){

                        try{
                            JsonArray names = null;
                            JsonArray types = null;
                            String ns = null;
                            String tag = null;

                            String path = getQueryPath().encodeToString();
                            String bqlSelect = "|bql:select slotPath ";
                            String bqlFrom = "from "+ getQueryBaseType();
                            String bqlWhere = " where name like \'";
                            String bqlType = "\' and type like \'";
                            String bqlEnd = "\'";

                            boolean validRule = true;

                            for(String e: rule.getAsJsonObject().keySet()){
                                JsonElement prop = rule.getAsJsonObject().get(e);

                                if(e.equals("ns") && prop.isJsonPrimitive()){
                                    ns = prop.getAsString();
                                }else if(e.equals("tag") && prop.isJsonPrimitive()){
                                    tag = prop.getAsString();
                                }else if(e.equals("types") && prop.isJsonArray()){
                                    types = prop.getAsJsonArray();
                                }else if(e.equals("names") && prop.isJsonArray()){
                                    names = prop.getAsJsonArray();
                                }else{
                                    logger.warning("ERROR - BuildAll...rule property type unknown...!");
                                    validRule = false;
                                    break;
                                }
                            }
                            if(validRule){
                                for(JsonElement el: names){
                                    String name = el.getAsString();

                                    for(JsonElement type: types){
                                        String bql = path.concat(bqlSelect.concat(bqlFrom.concat(bqlWhere + name))) +
                                                bqlType + type.getAsString() + bqlEnd;
                                        ArrayList<BComponent> queryObjects = resolver.resolve(BString.make( bql ));

                                        for (BComponent obj : queryObjects) {
                                            try{
                                                Id.verifyTagId(ns, tag);
                                                Id i = Id.newId(ns, tag);
                                                Tag t = Tag.newTag(i.getQName());
                                                obj.tags().set(t);
                                                logger.info("TAG ADDED: "+ t.getId().toString() +
                                                        "\t-\t" + obj.getSlotPath().toString());}
                                            catch(Exception e)
                                            {
                                                logger.warning("ERROR-TAG NOT ADDED: "+ e.getMessage());
                                                e.printStackTrace();
                                            }
                                        }
                                        logger.info(bql);
                                    }
                                }
                            }else{ logger.warning("ERROR - Invalid TagRule...!!!"); }

                        }catch(UnresolvedException ue){logger.severe(ue.getMessage()); ue.printStackTrace();}
                    }else{
                        logger.warning("ERROR - Rule is not a valid JSON object...!");
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