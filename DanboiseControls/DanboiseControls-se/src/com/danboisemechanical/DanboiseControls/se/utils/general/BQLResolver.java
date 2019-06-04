package com.danboisemechanical.DanboiseControls.se.utils.general;

import javax.baja.collection.BITable;
import javax.baja.collection.TableCursor;
import javax.baja.naming.BOrd;
import javax.baja.sys.BObject;
import javax.baja.sys.BString;
import javax.baja.sys.Sys;
import java.util.ArrayList;

public class BQLResolver {
    /***
     * resolve a slot path and a type into a qualified bql query, and return the list of BObject references.
     * @param type: Niagara type to use in the bql query.
     * @param stationPath: Station path used to qualify a bql query.
     * @return ArrayList<BObject>: Return an array-list of resolved BObjects to the caller.
     */

    public ArrayList<BObject> resolve(BString type, BString stationPath){
        ArrayList<BObject> objRefs = new ArrayList<>();
        BOrd ord =  BOrd.make(stationPath.getString().concat("|bql:select name from control:ControlPoint where type = "+type));
        BITable<BObject> t = (BITable)ord.resolve(Sys.getStation()).get();
        TableCursor<BObject> c = t.cursor();
        while(c.next()){
            try{
                objRefs.add(c.get());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return objRefs;
    }

    /***
     * resolve a qualified bql query, and return the list of BObject references.
     * @param query: fully qualified bql query.
     * @return ArrayList<BObject>
     */

    public  ArrayList<BObject> resolve(BString query){
        ArrayList<BObject> objRefs = new ArrayList<>();
        BOrd ord = BOrd.make(query.getString());
        BITable<BObject> t = (BITable)ord.resolve(Sys.getStation()).get();
        TableCursor<BObject> c = t.cursor();
        while(c.next()){
            try{
                objRefs.add(c.get());
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return objRefs;
    }
}
