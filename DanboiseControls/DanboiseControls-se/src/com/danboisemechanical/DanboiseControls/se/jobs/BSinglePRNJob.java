package com.danboisemechanical.DanboiseControls.se.jobs;

import com.danboisemechanical.DanboiseControls.se.builders.BPRNBuilder;
import com.danboisemechanical.DanboiseControls.se.models.n2.N2DevDef;
import com.danboisemechanical.DanboiseControls.se.models.n2.N2PointDef;
import com.danboisemechanical.DanboiseControls.se.services.BSysBuilderService;
import com.danboisemechanical.DanboiseControls.se.utils.general.BQLResolver;
import com.danboisemechanical.DanboiseControls.se.utils.n2parsers.PRNParser;

import com.jci.jcin2.BJciN2Network;
import com.jci.jcin2.BJciN2ODevice;
import com.jci.jcin2.enums.BJciN2ObjectType;
import com.jci.jcin2.point.BJciN2OBooleanProxyExt;
import com.jci.jcin2.point.BJciN2OEnumProxyExt;
import com.jci.jcin2.point.BJciN2ONumericProxyExt;
import com.jci.jcin2.point.BJciN2OPointDeviceExt;

import javax.baja.control.*;
import javax.baja.job.BSimpleJob;
import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.units.BUnit;
import javax.baja.util.BFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

@NiagaraType

public class BSinglePRNJob extends BSimpleJob {
/*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
/*@ $com.danboisemechanical.DanboiseControls.se.jobs.BSinglePRNJob(2979906276)1.0$ @*/
/* Generated Wed May 15 10:14:16 EDT 2019 by Slot-o-Matic (c) Tridium, Inc. 2012 */

////////////////////////////////////////////////////////////////
// Type
////////////////////////////////////////////////////////////////

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSinglePRNJob.class);

/*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  //PARENT METHOD OVERRIDES
  @Override
  public void run(Context cx) throws Exception{
    BPRNBuilder builder = ((BSysBuilderService)Sys.getService(BSysBuilderService.TYPE)).getPRNBuilder();

    n2Dev = prn.parseN2Dev(builder.getFileOrd(), builder, this);
    n2PointList = prn.parseN2Points(builder.getFileOrd(), builder, this);

    BComponent drivers = BOrd.make("slot:/Drivers").resolve(Sys.getStation()).getComponent();
    Arrays.stream(drivers.getChildComponents()).forEach(e -> {

      if(e.getType().getTypeName().equals("JciN2Network")){
        BJciN2Network n2 = (BJciN2Network)e;
        BJciN2ODevice dev = new BJciN2ODevice();
        String name = "";

        try{
          name = n2Dev.getDevName().replaceAll("\\W\\D", "_");
          name = name.replaceAll("\\)", "");

          BJciN2OPointDeviceExt devExt = new BJciN2OPointDeviceExt();
          n2PointList.stream().forEach(i -> {

              String pointType = i.getPointType();
              String shortName = i.getShortName();
              String longName = i.getLongName();
              int pointAddr = i.getPointAddress();

            if(i.getPointType().equals("AI")){

              BNumericPoint np = new BNumericPoint();
              BJciN2ONumericProxyExt proxyExt = new BJciN2ONumericProxyExt();
              String pointName = i.getShortName().replaceAll("-", "_");
              proxyExt.set("networkPointType", BJciN2ObjectType.analogInput);
              proxyExt.set("networkPointAddress", BInteger.make(i.getPointAddress()));
              proxyExt.set("shortName", BString.make(pointName));
              proxyExt.set("longName", BString.make(i.getLongName()));
              np.setProxyExt(proxyExt);
              if(i.getPointUnits().equals("%RH")){
                np.setFacets(BFacets.makeNumeric(BUnit.getUnit("percent relative humidity"), 0));
              }else if(i.getPointUnits().equals("deg F") || i.getPointUnits().contains("F delta")){
                np.setFacets(BFacets.makeNumeric(BUnit.getUnit("fahrenheit"), 1));
              }else if(i.getPointUnits().equals("in WC")){
                np.setFacets(BFacets.makeNumeric(BUnit.getUnit("inches of water"), 3));
              }else if(i.getPointUnits().equals("psi")){
                np.setFacets(BFacets.makeNumeric(BUnit.getUnit("pounds per square inch"), 1));
              }else if(i.getPointUnits().equals("ppm")){
                  np.setFacets(BFacets.makeNumeric(BUnit.getUnit("parts per million"),0));
              }else if(i.getPointUnits().equals("min")){
                  np.setFacets(BFacets.makeNumeric(BUnit.getUnit("minute"),0));
              }else if(i.getPointUnits().equals("%")){
                  np.setFacets(BFacets.makeNumeric(BUnit.getUnit("percent"), 0));
              }
              else{
                logger.warning("[WARNING] point units parsed from prn file not matched!!...BSinglePRNJob.java:101");
              }

              devExt.add(pointName, np);
              devExt.setDisplayName(devExt.getProperty(pointName), BFormat.make(i.getLongName()), null);
              log().message("SinglePRNJob..."+i.getShortName()+" - "+i.getPointType()+":"+i.getPointAddress());
//
          }else if(i.getPointType().equals("AO") || i.getPointType().equals("ADF") ||
                    (i.getPointType().equals("ADI") && i.getPointUnits().equals("min"))){

              BNumericWritable nw = new BNumericWritable();
              BJciN2ONumericProxyExt proxyExt = new BJciN2ONumericProxyExt();
              String pointName = i.getShortName().replaceAll("-", "_");
                if(i.getPointType().equals("AO")){
                    proxyExt.set("networkPointType", BJciN2ObjectType.analogOutput);
                }else if( i.getPointType().equals("ADI")){
                    proxyExt.set("networkPointType", BJciN2ObjectType.analogDataInteger);
                }else{
                    proxyExt.set("networkPointType", BJciN2ObjectType.analogDataFloat);
                }
              proxyExt.set("networkPointAddress", BInteger.make(i.getPointAddress()));
              proxyExt.set("shortName", BString.make(pointName));
              proxyExt.set("longName", BString.make(i.getLongName()));
              nw.setProxyExt(proxyExt);
              if(i.getPointUnits().equals("%")){
                nw.setFacets(BFacets.makeNumeric(BUnit.getUnit("percent"),0));
              }else if(i.getPointUnits().equals("%RH")){
                  nw.setFacets(BFacets.makeNumeric(BUnit.getUnit("percent relative humidity"), 0));
              }else if(i.getPointUnits().equals("deg F") || i.getPointUnits().contains("F delta")){
                  nw.setFacets(BFacets.makeNumeric(BUnit.getUnit("fahrenheit"), 1));
              }else if(i.getPointUnits().equals("in WC")){
                  nw.setFacets(BFacets.makeNumeric(BUnit.getUnit("inches of water"), 3));
              }else if(i.getPointUnits().equals("psi")){
                  nw.setFacets(BFacets.makeNumeric(BUnit.getUnit("pounds per square inch"), 1));
              }else if(i.getPointUnits().equals("ppm")){
                  nw.setFacets(BFacets.makeNumeric(BUnit.getUnit("parts per million"),0));
              }else if(i.getPointUnits().equals("min")){
                  nw.setFacets(BFacets.makeNumeric(BUnit.getUnit("minute"),0));
              }
              else{
                logger.warning("[WARNING] point units parsed from prn file not matched!!...BSinglePRNJob.java:141");
              }

              devExt.add(pointName, nw);
              devExt.setDisplayName(devExt.getProperty(pointName), BFormat.make(i.getLongName()), null);
              log().message("SinglePRNJob..."+i.getShortName()+" - "+i.getPointType()+":"+i.getPointAddress());

          }else if(i.getPointType().equals("BI")){

              BBooleanPoint bp = new BBooleanPoint();
              BJciN2OBooleanProxyExt proxyExt = new BJciN2OBooleanProxyExt();
              String pointName = i.getShortName().replaceAll("-", "_");
              proxyExt.set("networkPointType", BJciN2ObjectType.binaryInput);
              proxyExt.set("networkPointAddress", BInteger.make(i.getPointAddress()));
              proxyExt.set("shortName", BString.make(pointName));
              proxyExt.set("longName", BString.make(i.getLongName()));
              bp.setProxyExt(proxyExt);
              if(i.getPointUnits().equals("Off/On")){
                bp.setFacets(BFacets.make(BFacets.TRUE_TEXT, BString.make("On"),
                        BFacets.FALSE_TEXT, BString.make("Off")));
              }else if(i.getPointUnits().equals("Normal/Alarm")){
                bp.setFacets(BFacets.make(BFacets.TRUE_TEXT, BString.make("Alarm"),
                        BFacets.FALSE_TEXT, BString.make("Normal")));
              }else{
                logger.warning("[WARNING] point units parsed from prn file not matched!!...BSinglePRNJob.java:165");
              }

              devExt.add(pointName, bp);
              devExt.setDisplayName(devExt.getProperty(pointName), BFormat.make(i.getLongName()), null);
              log().message("SinglePRNJob..."+i.getShortName()+" - "+i.getPointType()+":"+i.getPointAddress());

            }else if(i.getPointType().equals("BO")){

              BBooleanWritable bp = new BBooleanWritable();
              BJciN2OBooleanProxyExt proxyExt = new BJciN2OBooleanProxyExt();
              String pointName = i.getShortName().replaceAll("-", "_");
              proxyExt.set("networkPointType", BJciN2ObjectType.binaryOutput);
              proxyExt.set("networkPointAddress", BInteger.make(i.getPointAddress()));
              proxyExt.set("shortName", BString.make(pointName));
              proxyExt.set("longName", BString.make(i.getLongName()));
              bp.setProxyExt(proxyExt);
              if(i.getPointUnits().equals("Off/On")){
                bp.setFacets(BFacets.make(BFacets.TRUE_TEXT, BString.make("On"),
                        BFacets.FALSE_TEXT, BString.make("Off")));
              }else{
                logger.warning("[WARNING] point units parsed from prn file not matched!!...BSinglePRNJob.java:186");
              }

              devExt.add(pointName, bp);
              devExt.setDisplayName(devExt.getProperty(pointName), BFormat.make(i.getLongName()), null);
              log().message("SinglePRNJob..."+i.getShortName()+" - "+i.getPointType()+":"+i.getPointAddress());

            }else if(i.getPointType().equals("ADI") && (!i.getPointUnits().equals("min"))){

                BEnumWritable ew = new BEnumWritable();
                BJciN2OEnumProxyExt proxyExt = new BJciN2OEnumProxyExt();
                String pointName = i.getShortName().replaceAll("-", "_");
                proxyExt.set("networkPointType", BJciN2ObjectType.analogDataInteger);
                proxyExt.set("networkPointAddress", BInteger.make(i.getPointAddress()));
                proxyExt.set("shortName", BString.make(pointName));
                proxyExt.set("longName", BString.make(i.getLongName()));
                if(i.getPointUnits().contains("/")){
                    String[] units = i.getPointUnits().split("/");
                    BEnumRange range = BEnumRange.make(units);
                    BDynamicEnum dyEnum = BDynamicEnum.make(units.length, range);
                    ew.set(dyEnum);
                }else{}

            }else{ logger.warning("[WARNING] point type parsed from prn file not matched!!...BSinglePRNJob.java:209"); }
          });

          dev.setPoints(devExt);
          log().message(devExt.getPropertiesArray().toString());
          n2.add(name, dev);

        }catch(IllegalNameException ine){
          name = "n2_vnd_dmi";
          n2.add(name, new BJciN2ODevice());

        }

        this.log().message(e.getType().getTypeName() + " FOUND... - BSinglePRNJob.java:222");
        this.log().message(n2Dev.getDevName()+" parsed from prn file...");
        this.log().message(name+" parsed name");
      }else{
        this.log().message("JciN2Network NOT FOUND ... while attempting to add n2 device from PRN file...!!! - BSinglePRNJob.java:226");
      }
    });

  }

  public void doCancel(Context cx){
      canceled = true;
      super.doCancel(cx);
  }

  //METHODS
  public void setCanceled(boolean b){ canceled = b; }
  public boolean getCanceled(){ return canceled; }

  //FIELDS
  private boolean canceled = false;
  private PRNParser prn = new PRNParser();
  private N2DevDef n2Dev;
  private ArrayList<N2PointDef>n2PointList;
  private Logger logger = Logger.getLogger("DMI_PRNBuilder");

}
