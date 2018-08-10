package de.uni_hannover.sim.evaplutta.Modell;

import de.uni_hannover.sim.evaplutta.Profiling.*;
import de.uni_hannover.sim.evaplutta.Simulation.*;

import java.util.*;

public class Road implements DataSource, Cloneable {

  /**
   * length of street (if street is 7 long, value will be 6 (including 0.th field)
   */
  private int length;
  /**
   * array with the same length of road, filled with either '0' or '1', represents slots on street. If '0' slot is free, if '1', slot is occupied, if any other integer is assigned, no evaluation can be made
   */
  private int[] legal;
  /**
   * Crossroad from which street starts
   */
  private Crossroad start;
  /**
   * Crossroad at which street ends
   */
  private Crossroad end;
  /**
   * represents greenphase of the street, will be compared to greenphase of trafficlights
   */
  String greenPhase;

  private double carcounter;

  private ArrayList<Double> roadLog = new ArrayList<Double>();

  private String name;

  public Road(String name, int length, Crossroad start, Crossroad end, String greenPhase) {
    this.name = name;
    this.length = length;
    legal = new int[length];
    this.start = start;
    this.end = end;
    this.greenPhase = greenPhase;

  }


  /**
   * @param  p represents position of car
   * @param a can be '0' or '1' (value of array 'legal')
   * @return -
   */
  public void setLegal(int p, int a) {
    legal[p] = a;
  }

  public String getStreetname() {
    return name;
  }

  /**
   * @param p represents position of car
   * @return value of 'legal' at index p
   */
  public int getLegal(int p) {
    return legal[p];
  }

  /**
   * @param -
   * @return length of road
   */
  public int getLength() {
    return length;
  }

  /**
   * @param -
   * @return start of route segment (Crossroad)
   */
  public Crossroad getStart() {
    return start;
  }

  /**
   * @param -
   * @return end of route segment (Crossroad)
   */
  public Crossroad getEnd() {
    return end;
  }

  /**
   * @param -
   * @return name of start Crossroad
   */
  public String getStreetNameStart() {
    return start.getCrossroadname();
  }

  /**
   * @param -
   * @return name of end Crossroad
   */
  public String getStreetNameEnd() {
    return end.getCrossroadname();
  }

  /**
   * @param  s set's greenphase of street, will be used for initializing
   * @return -
   */
  public void setGreenPhase(String s) {
    greenPhase = s;
  }

  /**
   * @param -
   * @return greenphase of the street
   */
  public String getGreenPhase() {
    return greenPhase;
  }

  /**
   * counts cars on street
   */
  public void setCarcounter(double c) {
    carcounter = c;
  }

  public int[] getwholeLegal() {
    return legal;
  }

  /**
   * counts cars on this street
   *
   * @return number of cars currently driving on this street
   * counts how many slots of the street are occupied and calculates sum
   */
  public double getCarcounter() {
    for (int i = 0; i < legal.length; i++) {
      if (legal[i] == 1) {
        carcounter++;
      }
    }
    return carcounter;
  }

  /**
   * adds current value 'carcounter' to log of Road
   */
  public void logStatus() {

    roadLog.add(getCarcounter());

  }

  /**
   * @return List of values, which represent the amount of cars that have been occupying slots on this street during the simulation has run.
   */
  public ArrayList<Double> getLog() {
    return roadLog;
  }

  public void printStatus() {
    System.out.printf("Cars on Road %s : %f\n", name, getCarcounter());
  }

}
