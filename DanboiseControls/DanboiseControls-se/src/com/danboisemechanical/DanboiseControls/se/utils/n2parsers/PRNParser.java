package com.danboisemechanical.DanboiseControls.se.utils.n2parsers;

import com.danboisemechanical.DanboiseControls.se.builders.BPRNBuilder;
import com.danboisemechanical.DanboiseControls.se.jobs.BSinglePRNJob;
import com.danboisemechanical.DanboiseControls.se.models.n2.N2DevDef;
import com.danboisemechanical.DanboiseControls.se.models.n2.N2PointDef;

import javax.baja.file.BIFile;
import javax.baja.job.JobCancelException;
import javax.baja.naming.BOrd;
import javax.baja.naming.UnresolvedException;
import javax.baja.sys.BComponent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PRNParser {

    //METHODS
    public N2DevDef parseN2Dev(BOrd fileOrd, BPRNBuilder caller, BSinglePRNJob job){
        BOrd ord = fileOrd;
        String[] props = new String[10];
        int breakCnt = 0;
        try{
            BIFile prnFile = (BIFile)ord.get(caller);
            InputStreamReader in = new InputStreamReader(prnFile.getInputStream());
            try{
                BufferedReader bin = new BufferedReader(in);
                String str;
                while((str = bin.readLine()) != null){
                    if(str.contains("Device Group         : ")){
                        props[0] = str.split(":")[1].replaceAll(" ", "").trim();
                        breakCnt = 0;
                    }else if(str.contains("Device Name")){
                        props[1] = str.split(":")[1].replaceAll(" ", "").trim();
                        breakCnt = 0;
                    }else{
                        breakCnt++;
                        if(breakCnt >= 30) break;
                    }
                }
            }finally{in.close();}
        }catch(UnresolvedException ue){
            logger.severe("File ORD is unresolved...!!\n"+ue.getCause());
        }catch(IOException ioe){
            logger.severe("File IO - Unknown file exception while trying to open the file from the ord specified...!!\n"
                    +ioe.getCause());
        }
        job.log().message("Device Group..."+props[0]);
        job.log().message("Device Name..."+props[1]);
        job.log().message(" ********************************** ");

        return N2DevDef.make(props[0], props[1]);
    }

    public String filter(String regex, String input){

        Pattern t = Pattern.compile(regex);
        StringBuilder sb = new StringBuilder();
        char[] ctp = input.toCharArray();
        for(int i = 0; i < ctp.length; i++){
            char[] chars = {ctp[i]};
            String s = new String(chars);
            if(t.matcher(s).matches()){
                sb.append(s);
            }else{
                logger.warning("PRNParser:90...ERROR matching...!!!");
            }
        }
        String tp = sb.toString();
        tp.trim();
        return tp;
    }

    public ArrayList<N2PointDef> parseN2Points(BOrd fileOrd, BPRNBuilder caller, BSinglePRNJob job){
        ArrayList<N2PointDef> n2Points = new ArrayList<>();
        try {

            BOrd ord = fileOrd;
            Pattern p = Pattern.compile(caller.getRegex());
            BIFile prnFile = (BIFile)ord.get(caller);
            InputStreamReader in = new InputStreamReader(prnFile.getInputStream());

            try {
                BufferedReader bin = new BufferedReader(in);
                String str;
                int cnt = 0;
                try{
                    while((str = bin.readLine()) != null){

                        if(job.getCanceled()) throw new JobCancelException();
                        if(p.matcher(str).matches()){
                            String[] objProps = str.split("\\s{3,}+");
                            String pointType = this.filter("[A-Z]", objProps[0]);
                            if(objProps.length == 4){
                                n2Points.add(N2PointDef.make(pointType, Integer.parseInt(objProps[1]), objProps[2], objProps[3], null));
                            }
                            else if(objProps.length == 5){
                                n2Points.add(N2PointDef.make(pointType, Integer.parseInt(objProps[1]), objProps[2], objProps[3], objProps[4]));
                                job.log().message("PRNParser..."+Arrays.asList(objProps).stream().collect(Collectors.joining(",")));
                            }else if(objProps.length == 6){
                                n2Points.add(N2PointDef.make(pointType, Integer.parseInt(objProps[1]), objProps[2], objProps[3], objProps[5]));
                                job.log().message("PRNParser..."+Arrays.asList(objProps).stream().filter(e-> e.equals(objProps[4]))
                                        .collect(Collectors.joining(",")));
                            }else{
                                logger.warning("PRNParser:121...NOT INCLUDED !!!!!\n"+
                                        Arrays.asList(objProps).stream().collect(Collectors.joining(",")));
                                job.log().message("PRNParser...Length: "+objProps.length);
                            }
                        }
                        ++cnt;
                        //job.progress((int)((double)cnt / (double)nOfLines)*100);
                    }
                }catch(IOException ioe){
                    logger.severe("PRNParser:130 - File IO - Unknown file exception while trying to open the file from the ord specified...!!\n"
                            + ioe.getCause());
                }
                job.progress(100);

            }finally {
                in.close();
            }

        }catch (UnresolvedException ue) {
            logger.severe("PRNParser:140 - File ORD is unresolved...!!\n" + ue.getCause());
        }catch (IOException ioe) {
            logger.severe("PRNParser:142 - File IO - Unknown file exception while trying to open the file from the ord specified...!!\n"
                    + ioe.getCause());
        }

        return n2Points;
    }

    public String parse(String regex, BOrd fileOrd, BComponent caller, BSinglePRNJob job){

        if(job.getCanceled()) throw new JobCancelException();
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile(regex);
        BOrd ord = fileOrd;
        try{
            BIFile prnFile = (BIFile)ord.get(caller);
            InputStreamReader in = new InputStreamReader(prnFile.getInputStream());
            try{
                BufferedReader bin = new BufferedReader(in);
                String str;
                int lineCount = 0;
                while((str = bin.readLine()) != null){
                    if(p.matcher(str).matches()){
                        ++lineCount;
                        logger.info(str);
                        job.log().message(str);
                        sb.append(str.concat("\n"));
                    }
                }
            }finally{
                in.close();
            }
        }catch(UnresolvedException ue){
            logger.severe("File ORD is unresolved...!!\n"+ue.getCause());
        }catch(IOException ioe){
            logger.severe("File IO - Unknown file exception while trying to open the file from the ord specified...!!\n"
                    +ioe.getCause());
        }
        return sb.toString();
    }

    public ArrayList<String> parseToCSV(String regex, BOrd fileOrd, BComponent caller, BSinglePRNJob job) {

        ArrayList<String> csvTable = new ArrayList<>();
        try {

            BOrd ord = fileOrd;
            Pattern p = Pattern.compile(regex);
            BIFile prnFile = (BIFile)ord.get(caller);
            InputStreamReader in = new InputStreamReader(prnFile.getInputStream());

            try {
                BufferedReader bin = new BufferedReader(in);
                String str;
                //int nOfLines = (int)bin.lines().count();
                int cnt = 0;
                try{
                    while((str = bin.readLine()) != null){

                        if(job.getCanceled()) throw new JobCancelException();

                        if(p.matcher(str).matches()){
                            String csvString = str.replaceAll("\\s{3,}+", ",");
                            csvTable.add(csvString);
                            job.log().message("CSV line: "+csvString);
                        }
                        ++cnt;
                        //job.progress((int)((double)cnt / (double)nOfLines)*100);
                    }
                }catch(IOException ioe){
                    logger.severe("File IO - Unknown file exception while trying to open the file from the ord specified...!!\n"
                            + ioe.getCause());
                }
                job.progress(100);

            }finally {
                in.close();
            }

        }catch (UnresolvedException ue) {
            logger.severe("File ORD is unresolved...!!\n" + ue.getCause());
        }catch (IOException ioe) {
            logger.severe("File IO - Unknown file exception while trying to open the file from the ord specified...!!\n"
                    + ioe.getCause());
        }

        return csvTable;
    }

    public ArrayList<String> parseToCSV(String regex, BOrd fileOrd, BComponent caller) {

        ArrayList<String> csvTable = new ArrayList<>();
        try {

            BOrd ord = fileOrd;
            Pattern p = Pattern.compile(regex);
            BIFile prnFile = (BIFile)ord.get(caller);
            InputStreamReader in = new InputStreamReader(prnFile.getInputStream());

            try {
                BufferedReader bin = new BufferedReader(in);
                String str;
                //int nOfLines = (int)bin.lines().count();
                int cnt = 0;
                try{
                    while((str = bin.readLine()) != null){


                        if(p.matcher(str).matches()){
                            String csvString = str.replaceAll("\\s{3,}+", ",");
                            csvTable.add(csvString);
                        }
                        ++cnt;
                        //job.progress((int)((double)cnt / (double)nOfLines)*100);
                    }
                }catch(IOException ioe){
                    logger.severe("File IO - Unknown file exception while trying to open the file from the ord specified...!!\n"
                            + ioe.getCause());
                }

            }finally {
                in.close();
            }

        }catch (UnresolvedException ue) {
            logger.severe("File ORD is unresolved...!!\n" + ue.getCause());
        }catch (IOException ioe) {
            logger.severe("File IO - Unknown file exception while trying to open the file from the ord specified...!!\n"
                    + ioe.getCause());
        }

        return csvTable;
    }

    //FIELDS
    private static Logger logger = Logger.getLogger("DMI_SysBuilder_PRNBuilder");
}
