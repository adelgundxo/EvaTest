package de.uni_hannover.sim.evaplutta.Modell;
import de.uni_hannover.sim.evaplutta.Simulation.*;
import de.uni_hannover.sim.evaplutta.Profiling.*;
import java.util.*;


public abstract class Crossroad extends Actor{

/**
* name of Crossroad
*/
private String name;
private Road innorth;
private Road outnorth;
private Road insouth;
private Road outsouth;
private Road inwest;
private Road outwest;
private Road ineast;
private Road outeast;


public Crossroad(String name, Road innorth, Road outnorth, Road insouth,Road outsouth, Road inwest,Road outwest, Road ineast, Road outeast, Simulation simulation){
super(simulation, name);
this.name = name;
this.innorth = innorth;
this.outnorth = outnorth;
this.insouth = insouth;
this.outsouth = outsouth;
this.inwest = inwest;
this.outwest = outwest;
this.ineast = ineast;
this.outeast = outeast;

}
/**
* @param Road r: road to assign to outsouth
* @return -
*/
public void setOutsouth(Road r){
    outsouth = r;
}
/**
* @param Road r: road to assign to insouth
* @return -
*/
public void setInsouth(Road r){
    insouth = r;
}
/**
* @param Road r: road to assign to outnorth
* @return -
*/
public void setOutnorth(Road r){
    outnorth = r;
}
/**
* @param Road r: road to assign to innorth
* @return -
*/
public void setInnorth(Road r){
    innorth = r;
}
/**
* @param Road r: route to assign to outwest
* @return -
*/
public void setOutwest(Road r){
    outwest = r;
}
/**
* @param Road r: route to assign to inwest
* @return -
*/
public void setInwest(Road r){
    inwest = r;
}
/**
* @param Road r: route to assign to outeast
* @return -
*/
public void setOuteast(Road r){
    outeast = r;
}
/**
* @param Road r: route to assign to ineast
* @return -
*/
public void setIneast(Road r){
    ineast = r;
}
/**
* @param -
* @return name of Crossroad
*/
public String getCrossroadname(){
    return name;
}

public Road getInnorth(){return innorth;}
public Road getOutnorth(){return outnorth;}
public Road getInsouth(){return insouth;}
public Road getOutsouth(){return outsouth;}
public Road getInwest(){return inwest;}
public Road getOutwest(){return outwest;}
public Road getIneast(){return ineast;}
public Road getOuteast(){return outeast;}

/**
* @param Crossroad f: Crossroad from which route segment starts
* @param Crossroad t: Crossroad at which route segment ends
* @return Road which connects both crossroads 
*/

public Road getroad(Crossroad f, Crossroad t) {

    if(f != null && t != null){
        Crossroad from = f;
        Crossroad to = t;


        if (from.innorth != null && from.innorth.getEnd() == to) {
            return from.innorth;
        }
        if (from.outnorth != null && from.outnorth.getEnd() == to) {
            return from.outnorth;
        }
        
        if (from.insouth != null && from.insouth.getEnd() == to) {
            return from.insouth;
        }
        if (from.outsouth != null && from.outsouth.getEnd() == to) {
            return from.outsouth;
        }
        
        
        if (from.inwest != null && from.inwest.getEnd() == to) {
            return from.inwest;
        }
        if (from.outwest != null && from.outwest.getEnd() == to) {
            return from.outwest;
        }
        
        
        if (from.ineast != null && from.ineast.getEnd() == to) {
            return from.ineast;
        }
        if (from.outeast != null && from.outeast.getEnd() == to) {
            return from.outeast;
        }
         return null;
   } 
  return null;  
}



}
