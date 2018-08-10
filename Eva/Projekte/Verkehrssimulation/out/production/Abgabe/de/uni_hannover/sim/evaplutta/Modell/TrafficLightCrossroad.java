package de.uni_hannover.sim.evaplutta.Modell;

import de.uni_hannover.sim.evaplutta.Simulation.*;
import de.uni_hannover.sim.evaplutta.Profiling.*;

import java.util.*;

public class TrafficLightCrossroad extends Crossroad implements DataSource {
  /**
   * counter for the duration of greenlight-phase
   */
  private int remainingtime;
  /**
   * either "Red" or "Green"
   */
  private String phase;
  /**
   * used to reset duration of greenlight-phase, won't be modified
   */
  private int fixtime;

  /**
   * List which collects sum-values from logStatus
   */

  private ArrayList<Double> crossroadLog = new ArrayList<Double>();

  private double sum;

  public TrafficLightCrossroad(String name, Road innorth, Road outnorth, Road insouth, Road outsouth, Road inwest, Road outwest, Road ineast, Road outeast, Simulation simulation, int remainingtime, String phase) {

    super(name, innorth, outnorth, insouth, outsouth, inwest, outwest, ineast, outeast, simulation);

    this.remainingtime = remainingtime;
    this.phase = phase;
    this.fixtime = remainingtime;


  }

  /**
   * @param -
   * @return phase, which means greenlight-phase ("Red" / "Green")
   */
  public String getPhase() {
    return phase;
  }

  /**
   * @param  s : set phase
   * @return -
   */
  public void setPhase(String s) {
    phase = s;
  }

  /**
   * @param -
   * @return -
   * counts down duration of phase, phase will be switched when counter is '0'.
   */
  @Override
  public void update() {

    remainingtime--;
    if (remainingtime == 0) {
      if (phase == "Green") {
        System.out.println("AMPELPHASENWECHSEL TO RED (cars on west/east roads can drive)");
        phase = "Red";
        remainingtime = fixtime;
      } else if (phase == "Red") {
        System.out.println("AMPELPHASENWECHSEL TO GREEN (cars on north/south can drive)");
        phase = "Green";
        remainingtime = fixtime;
      }

    }


  }

  /**
   * This method sums up the numbers of cars which are waiting on streets, which enter a TrafficLightCrossroad and have currently "Red".
   */
  @Override
  public void logStatus() {

    sum = 0;
    if (phase == "Red") {
      if (getInnorth() != null) {
        sum += getInnorth().getCarcounter();
      }
      if (getOutnorth() != null) {
        sum += getOutnorth().getCarcounter();
      }
      if (getInsouth() != null) {
        sum += getInsouth().getCarcounter();
      }
      if (getOutsouth() != null) {
        sum += getOutsouth().getCarcounter();
      }
    } else if (phase == "Green") {
      if (getInwest() != null) {
        sum += getInwest().getCarcounter();
      }
      if (getOutwest() != null) {
        sum += getOutwest().getCarcounter();
      }
      if (getIneast() != null) {
        sum += getIneast().getCarcounter();
      }
      if (getOuteast() != null) {
        sum += getOuteast().getCarcounter();
      }
    }
    crossroadLog.add(sum);
  }


  /**
   * @return protocoll of the behaviour of this TrafficLightCrossroad
   */

  @Override
  public ArrayList<Double> getLog() {
    return crossroadLog;
  }

  public void printStatus() {
    System.out.printf("Ampelphase: %s\n", phase);
  }

}
