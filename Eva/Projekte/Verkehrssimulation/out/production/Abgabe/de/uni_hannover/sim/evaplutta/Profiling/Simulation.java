package de.uni_hannover.sim.evaplutta.Simulation;

import de.uni_hannover.sim.evaplutta.Modell.*;
import de.uni_hannover.sim.evaplutta.Profiling.*;

import java.util.*;


public class Simulation implements Cloneable {
  private TrafficLightCrossroad crossroadC;
  private Systemborder crossroadA;
  private Systemborder crossroadB;
  private Systemborder crossroadE;
  private Systemborder crossroadD;

  private Road north;
  private Road south;
  private Road west;
  private Road east;

  private ArrayList<Actor> actors;
  private ArrayList<ArrayList<Crossroad>> routesforA;
  private ArrayList<ArrayList<Crossroad>> routesforB;
  private ArrayList<Road> roads;
  private ArrayList<Crossroad> routeA1;
  private ArrayList<Crossroad> routeA2;
  private ArrayList<Crossroad> routeB1;
  private ArrayList<Crossroad> routeB2;
  /**
   * stores the actors/roads to inspect
   */
  private ArrayList<DataSource> activeactors;
  private static Random rnd = new Random();
  /**
   * These are the parsed names from cmd
   */
  private static String[] inspectednames = new String[0];
  /**
   * used to activate the evaluation process for travelling time
   */
  private static int protocoll = 0;
  /**
   * List of lifetimes of cars which passed the System
   */
  private ArrayList<Double> travellingtime;
  /**
   * used for storage
   */
  private int lifetimetoarchive;
  private double storagedeviation;
  private double storagemean;
  private static int settling;
  private static int repeater;
  private int wholetime;
  private static int time;
  private static int wholetimefix;
  public Simulation copy;


  public Simulation() {


    crossroadA = new Systemborder("CrossroadA", null, null, null, null, null, null, null, null, 0.2, routesforA, this);
    crossroadB = new Systemborder("CrossroadB", null, null, null, null, null, null, null, null, 0.3, routesforB, this);
    crossroadE = new Systemborder("CrossroadE", null, null, null, null, null, null, null, null, 0.0, null, this);
    crossroadC = new TrafficLightCrossroad("CrossroadC", null, null, null, null, null, null, null, null, this, 4, "Green");
    crossroadD = new Systemborder("CrossroadD", null, null, null, null, null, null, null, null, 0.0, null, this);


    north = new Road("RoadAC", 7, crossroadA, crossroadC, "Green");
    //Straße von A nach C
    west = new Road("RoadBC", 4, crossroadB, crossroadC, "Red");
    //Straße von B nach C
    south = new Road("RoadCE", 3, crossroadC, crossroadE, "Green");
    //Straße von C nach E
    east = new Road("RoadCD", 5, crossroadC, crossroadD, "Red");

    routeA1 = new ArrayList<Crossroad>();
    routeA1.addAll(Arrays.asList(crossroadA, crossroadC, crossroadD));
    routeA2 = new ArrayList<Crossroad>();
    routeA2.addAll(Arrays.asList(crossroadA, crossroadC, crossroadE));

    routesforA = new ArrayList<ArrayList<Crossroad>>();
    routesforA.addAll(Arrays.asList(routeA1, routeA2));

    routeB1 = new ArrayList<Crossroad>();
    routeB1.addAll(Arrays.asList(crossroadB, crossroadC, crossroadD));
    routeB2 = new ArrayList<Crossroad>();
    routeB2.addAll(Arrays.asList(crossroadB, crossroadC, crossroadE));

    //Routen müssen mitgegeben werden an GetRoutes() von Car

    routesforB = new ArrayList<ArrayList<Crossroad>>();
    routesforB.addAll(Arrays.asList(routeB1, routeB2));

    roads = new ArrayList<Road>();
    roads.addAll(Arrays.asList(north, west, south, east));


    crossroadA.setOutsouth(north);
    crossroadB.setOuteast(west);
    crossroadC.setInnorth(north);
    crossroadC.setOutsouth(south);
    crossroadC.setInwest(west);
    crossroadC.setOuteast(east);
    crossroadD.setInwest(east);
    crossroadE.setInnorth(south);
    crossroadA.setPossibleRoutes(routesforA);
    crossroadB.setPossibleRoutes(routesforB);


    actors = new ArrayList<Actor>();
    actors.addAll(Arrays.asList(crossroadA, crossroadB, crossroadC, crossroadD, crossroadE));

    activeactors = new ArrayList<DataSource>();
    travellingtime = new ArrayList<Double>();

    for (String name : Simulation.inspectednames) {

      if (name.equals("CrossroadC")) {
        activeactors.add(((DataSource) (crossroadC)));
      }
      for (int z = 0; z < roads.size(); z++) {
        if (name.equals(roads.get(z).getStreetname())) {
          activeactors.add(((DataSource) (roads.get(z))));
        }
      }
    }


  }

  public ArrayList<Crossroad> getRouteA2() {
    return routeA2;
  }

  public ArrayList<Crossroad> getRouteA1() {
    return routeA1;
  }

  public ArrayList<Crossroad> getRouteB1() {
    return routeB1;
  }

  public ArrayList<Crossroad> getRouteB2() {
    return routeB2;
  }

  public ArrayList<Crossroad> getRoute(Crossroad start, Crossroad end) {
    if (start.getCrossroadname().equals("CrossroadA") && end.getCrossroadname().equals("CrossroadD")) {
      return getRouteA1();
    }
    if (start.getCrossroadname().equals("CrossroadA") && end.getCrossroadname().equals("CrossroadE")) {
      return getRouteA2();
    }
    if (start.getCrossroadname().equals("CrossroadB") && end.getCrossroadname().equals("CrossroadD")) {
      return getRouteB1();
    }
    if (start.getCrossroadname().equals("CrossroadB") && end.getCrossroadname().equals("CrossroadE")) {
      return getRouteB2();
    }
    return null;
  }

  public static void setSettling(int i) {
    settling = i;
  }

  public static void setRepeater(int i) {
    repeater = i;
  }

  public static void setProtocoll(int i) {
    protocoll = i;
  }

  public static void setRnd(long seed) {
    rnd = new Random(seed);
  }

  public static Random getRnd() {
    return rnd;
  }

  public static void setInspectednames(String[] s) {
    inspectednames = s;
  }

  public static String[] getInspectednames() {
    return inspectednames;
  }

  public ArrayList<Actor> getActors() {
    return actors;
  }

  public ArrayList<DataSource> getActiveactors() {
    return activeactors;
  }

  public static void setTime(int i) {
    time = i;
  }


  @Override
  public Simulation clone() throws CloneNotSupportedException {
    Simulation cloned = new Simulation();
    for (int i = 0; i < this.actors.size(); i++) {
      if (this.actors.get(i) != null && this.actors.get(i) instanceof Car) {
        cloned.actors.add(((Car) (this.actors.get(i))).clone(cloned));
      }
    }
    for (int i = 0; i < activeactors.size(); i++) {
      if (this.activeactors.get(i) != null && this.activeactors.get(i) instanceof Car) {
        cloned.activeactors.add(((Car) (activeactors.get(i))).clone(cloned));
      }
    }
    cloned.setTime(this.time - this.settling);
    cloned.setSettling(0);
    cloned.crossroadC.setPhase(this.crossroadC.getPhase());
    cloned.rnd = new Random();
    for (int i = 0; i < cloned.roads.size(); i++) {
      for (int j = 0; j < cloned.roads.get(i).getwholeLegal().length; j++) {
        cloned.roads.get(i).setLegal(j, this.roads.get(i).getLegal(j));
      }
    }
    return cloned;
  }

  private void copySim() throws CloneNotSupportedException {
    for (int i = 0; i < repeater; i++) {
      clone().run();
    }
  }

  private void computeStatistics() {

    if (protocoll == 1) {
      double num = Statistics.calculateMean(travellingtime);

      System.out.println(num);
      System.out.println("timesteps travelling (mean)");
    }
    for (int p = 0; p < activeactors.size(); p++) {
      if (activeactors.get(p) instanceof Car) {
        storagedeviation = Statistics.calculateStandardDeviation(((Car) (activeactors.get(p))).getLog());
        storagemean = Statistics.calculateMean(((Car) (activeactors.get(p))).getLog());

        System.out.println("Standard deviation of");
        System.out.printf("%s %d ", ((Car) (activeactors.get(p))).getName(), ((Car) (activeactors.get(p))).getIdentity());
        System.out.printf("'s movement: ");
        System.out.println(storagedeviation);
        System.out.println("Mean movement: ");
        System.out.println(storagemean);
        System.out.printf("\n\n");


      }
      if (activeactors.get(p) instanceof TrafficLightCrossroad) {
        storagedeviation = Statistics.calculateStandardDeviation(((TrafficLightCrossroad) (activeactors.get(p))).getLog());
        storagemean = Statistics.calculateMean(((TrafficLightCrossroad) (activeactors.get(p))).getLog());

        System.out.println("Standard deviation of cars waiting at red traffic light: ");
        System.out.println(storagedeviation);

        System.out.println("Mean value of cars waiting at red traffic light: ");
        System.out.println(storagemean);
      }
      if (activeactors.get(p) instanceof Road) {
        storagedeviation = Statistics.calculateStandardDeviation(((Road) (activeactors.get(p))).getLog());
        storagemean = Statistics.calculateMean(((Road) (activeactors.get(p))).getLog());

        System.out.printf("Standard deviation of cars on this street:");
        System.out.printf("%s is: ", ((Road) (activeactors.get(p))).getStreetname());
        System.out.println(storagedeviation);

        System.out.println("Mean number of cars on it: ");
        System.out.println(storagemean);

      }
    }

  }

  /**
   * @param -
   * @return -
   * Simulation runs during the given time. At every timestep, this method calls the 'update' function for every active member of Simulation (every entry of actors). It also removes deactivated cars from the Simulation. Furthermore, it makes shure that only the actors from cmd-Input will be evaluated and printed.
   */

  public void run() throws CloneNotSupportedException {

    wholetime = time + settling;
    wholetimefix = wholetime;


    System.out.printf("Verkehrssimulation: \n\n");


    while (wholetime != 0) {


      System.out.println("...............................UPDATE....................................\n");
      System.out.println("Point in time: " + wholetime);


      for (int i = 0; i < actors.size(); i++) {


        if (actors.get(i) != null) {

          actors.get(i).update();

          if (actors.get(i) instanceof Car && ((Car) (actors.get(i))).getActivity() == false) {

            if (wholetime < (wholetimefix - settling)) {
              lifetimetoarchive = ((Car) (actors.get(i))).getLifetime();
              travellingtime.add(((double) (lifetimetoarchive)));

            }
            actors.remove(i);
            i--;
          }

          if (actors.get(i) instanceof DataSource && wholetime < wholetimefix - settling) {
            ((DataSource) (actors.get(i))).logStatus();
          }

        }
      }


      for (int j = 0; j < roads.size(); j++) {
        if (wholetime < wholetimefix - settling) {
          roads.get(j).logStatus();
          roads.get(j).setCarcounter(0);
        }
      }
      for (int g = 0; g < activeactors.size(); g++) {
        if (wholetime < wholetimefix - settling) {
          if (activeactors.get(g) instanceof Car) {
            if (((Car) (activeactors.get(g))).getActivity()) {
              ((Car) (activeactors.get(g))).printcar();
              ((Car) (activeactors.get(g))).printStatus();
            }
          } else {
            ((DataSource) (activeactors.get(g))).printStatus();
          }
        }
      }

      wholetime--;
      if (settling != 0 && wholetime == wholetimefix - settling) {
        this.copySim();
      }

    }
    if (wholetime == 0) {
      computeStatistics();
    }


  }
}
    
