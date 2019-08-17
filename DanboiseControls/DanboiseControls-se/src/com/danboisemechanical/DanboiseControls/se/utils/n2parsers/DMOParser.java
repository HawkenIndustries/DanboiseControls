package com.danboisemechanical.DanboiseControls.se.utils.n2parsers;

import com.danboisemechanical.DanboiseControls.se.builders.BDMOBuilder;
import com.danboisemechanical.DanboiseControls.se.jobs.BSingleDMOJob;
import com.danboisemechanical.DanboiseControls.se.models.n2.N2DevDef;
import com.danboisemechanical.DanboiseControls.se.models.n2.N2PointDef;

import javax.baja.file.BIFile;
import javax.baja.job.JobCancelException;
import javax.baja.naming.BOrd;
import javax.baja.naming.UnresolvedException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class DMOParser extends PRNParser {

    public N2DevDef parseN2Dev(BOrd fileOrd, BDMOBuilder caller, BSingleDMOJob job){

        String devName = "";
        try{

            BIFile dmoFile = (BIFile) fileOrd.get(caller);
            InputStreamReader in = new InputStreamReader(dmoFile.getInputStream());
            try{
                BufferedReader bin = new BufferedReader(in);
                String line;
                while((line = bin.readLine()) != null){
                    if(job.getCanceled())throw new JobCancelException();
                    if(line.contains("CSMODEL")){
                        devName = (line.split(","))[1];
                    }
                }
            }finally{in.close();}
        }catch(UnresolvedException ue){
            logger.severe(ue.getMessage());
            ue.printStackTrace();
        }catch(IOException ioe){
            logger.severe(ioe.getMessage());
            ioe.printStackTrace();
        }catch(Exception e){
            logger.severe(e.getMessage());
            e.printStackTrace();
        }
        return N2DevDef.make("", devName);
    }

    public ArrayList<N2PointDef> parseN2Point(BOrd fileOrd, BDMOBuilder caller, BSingleDMOJob job){

        ArrayList<N2PointDef>  points = new ArrayList();

        try{
            BOrd ord = fileOrd;
            Pattern p = Pattern.compile(caller.getRegex());
            BIFile dmoFile = (BIFile)ord.get(caller);
            InputStreamReader in = new InputStreamReader(dmoFile.getInputStream());
            try{
                BufferedReader bin = new BufferedReader(in);
                String line;
                while((line = bin.readLine()) != null){
//                    * LONGNAME "SWITCH ROOM ZN1-T"
//                    CSAI "AI3",N,N,"OA_TT","Deg F"
//                    CSBI "DI1",N,N,"FIRE_ALM","OFF","ON"
//                    CSAO "OUT1",N,N,"AO1","%"
//                    CSBO "DO3",N,N,"BMS_CMD","OFF","ON"
//                    CSBD "PM3DO1",N,N,"ZN1ONDLY","OFF","ON"
//                    CSBD "PM3CT1",N,N,"PM3HLD1","OFF","ON"
//                    CSAD "PM2K1",N,N,"PM2K1-1",""
//                    CSAD "PM2OU2",N,N,"ZN1-SP2",""
//                    CSBD "LRS1",N,N,"AC1-ENAB","OFF","ON"

                    String longName = "";
                    boolean rw = true;
                    String[] pointRoot = line.split(" ");
                    String[] pointProps = (pointRoot[1]).split(",");
                    if(line.contains("LONGNAME")){longName = (line.split(" "))[2];}
                    if((pointProps[1]).equals("N") || (pointProps[2]).equals("N")) rw = false;

                    switch(pointRoot[0]){
                        case "CSAI":
                            for(String prop : pointProps){
                                prop.replace("\"", "");
                            }
                            points.add(N2PointDef.make(
                                    (pointRoot[0]).replace("CS", ""),
                                    Integer.parseInt((pointProps[0]).replace("AI","")),
                                    longName,
                                    pointProps[3],
                                    pointProps[4],
                                    rw ));
                            break;
                        case "CSBI":
                            break;
                        case "CSAO":
                            break;
                        case "CSBO":
                            break;
                        case "CSBD":
                            break;
                        case "CSAD":
                            break;
                        default:
                            break;
                    }
                }
            }finally{in.close();}
        }catch(IOException ioe){
            logger.severe(ioe.getMessage());
            ioe.printStackTrace();
        }catch(Exception e){
            logger.severe(e.getMessage());
            e.printStackTrace();
        }

        return points;
    }

    private static Logger logger = Logger.getLogger("DMI_SysBuilder_DMOBuilder");
}
