package de.uni_hannover.sim.evaplutta.Modell;

import de.uni_hannover.sim.evaplutta.Simulation.*;
import de.uni_hannover.sim.evaplutta.Profiling.*;

import java.util.*;

public class Car extends Actor implements DataSource, Cloneable {
  /**
   * represents location of car on street
   */
  private int location;
  /**
   * represents wether a car is an active actor of Simulation of not
   */
  private boolean caractive;
  /**
   * name of car
   */
  private String name;
  /**
   * length of car
   */
  private int length;
  /**
   * List of crossroads: start, via, end
   */
  private List<Crossroad> route;
  /**
   * lifetime of the car
   */
  private int lifetime;
  /**
   * entry of route, represents start of current route-segment
   */
  private int from;
  /**
   * entry of route, represents end of current route-segment
   */
  private int to;
  /**
   * entry of route, represents start of current route-segment
   */
  private Crossroad routestart;
  /**
   * entry of route, represents end of current route-segment
   */
  private Crossroad routeend;
  /**
   * name of entry of route, represents the name of start of current route-segment
   */
  private String currentstreet;
  /**
   * name of entry of route, represents name of end of current route-segment
   */
  private String destination;
  private ArrayList<Double> drivingstatus = new ArrayList<Double>();
  //später [simulationtime]
  private double hasdriven;
  private int identify;
  private Car copy;

  public Car(String name, int location, int identify, List<Crossroad> route, int lifetime, Simulation simulation, boolean caractive) {
    super(simulation, name);
    this.name = name;
    this.location = location;
    this.identify = identify;
    this.route = route;
    this.lifetime = lifetime;
    from = 0;
    to = 1;
    this.caractive = caractive;
  }

  /**
   * This method is used to aktivate/deactivate one car.
   *
   * @param b boolean, true means that the car should be activated, false deactivated.
   * @return -
   */
  public void setActivity(boolean b) {
    caractive = b;
  }

  /**
   * This method returns wether a car is an active actor of the simululation.
   *
   * @param -
   * @return caractive, boolean (true: active, false: inactive)
   */
  public boolean getActivity() {
    return caractive;
  }

  public String getName() {
    return name;
  }

  public double getStatus() {
    return hasdriven;
  }

  public int getLifetime() {
    return lifetime;
  }

  public int getIdentity() {
    return identify;
  }

  public int getLocation() {
    return location;
  }

  public Crossroad getRouteParts(int i) {
    return route.get(i);
  }

  /**
   * This method checks on the state of a car in Simulation and updates it's
   * state.
   * includes car-aging and traffic movement.
   * Reched end of street? -> check wether car has reached the end of it's route -> if true: set caractive to false.
   * If false: if there are no cars in front of it: turn
   * If the Crossroad has traffic lights: consider the greenphase, drive if allowed to.
   *
   * @param -
   * @return -
   */


  @Override
  public void update() {
    routestart = route.get(from);
    routeend = route.get(to);
    Road road = route.get(from).getroad(routestart, routeend);
    road.setLegal(location, 0);
    lifetime++;

    if (location == road.getLength() - 1) {
      //sind wir am straßenende?
      if (to == route.size() - 1) {
        //Sind wir am Routenende?
        caractive = false;
      } else {
        //Abbiegevorgang
        if (this.route.get(this.to) instanceof TrafficLightCrossroad) {
          if (((TrafficLightCrossroad) (this.route.get(this.to))).getPhase() != this.route.get(this.from).getroad(routestart, routeend).greenPhase) {
            road.setLegal(location, 1);
            /*    System.out.println(this.name + " ain't driving because this car is waiting at a red traffic light :'("); */
            hasdriven = 0.0;
            return;
          }
        }
        from++;
        to++;
        routestart = route.get(from);
        routeend = route.get(to);

        if (route.get(from).getroad(routestart, routeend).getLegal(0) == 0) {
          //ist 0.Feld der neuen straße frei?
          location = 0;
          route.get(from).getroad(routestart, routeend).setLegal(0, 1);
          System.out.println(name + " This car will turn and drive on another street\n\n");
          hasdriven = 1;
        } else {
          from--;
          to--;
          System.out.println(name + " ain't driving because 0.th slot of new route segment is occupied\n");
          hasdriven = 0;
          return;
        }
      }
    } else if (location + 1 < road.getLength()) {
      if (road.getLegal(location + 1) == 0) {
//Feld frei?
        location++;
        road.setLegal(location, 1);
        hasdriven = 1;
      } else {
        System.out.printf("%s ain't driving because driver doesn't want to provoke a carcrash! \n", name);
        hasdriven = 0;
        return;
      }
    }
  }

  /**
   * This method provides the output of the state of one car in the simulation.
   * Car is only printed out when it's active and a member of activeactors
   *
   * @param -
   * @return -
   */
  public void printcar() {

    currentstreet = this.route.get(this.from).getCrossroadname();
    destination = this.route.get(this.to).getCrossroadname();

    if (this.caractive == true) {

      System.out.printf("%s %d: ", this.name, this.identify);
      System.out.printf(" %s", currentstreet);
      System.out.printf(" -> -> %s", destination);
      System.out.printf(" on Slot: %d ", this.location);
      System.out.printf("Lifetime: %d\n\n", this.lifetime);
    }
  }

  public void printStatus() {

    System.out.printf("moved?: %s %d  ", name, identify);
    System.out.println(hasdriven);
    System.out.printf("\n\n");
  }

  @Override

  public void logStatus() {
    drivingstatus.add(hasdriven);
  }

  @Override
  public ArrayList<Double> getLog() {
    return drivingstatus;
  }

  public Car clone(Simulation cloned) throws CloneNotSupportedException {

    Car clonedCar = new Car(this.getName(), this.getLocation(), this.getIdentity(), null, this.getLifetime(), cloned, this.getActivity());
    clonedCar.from = this.from;
    clonedCar.to = this.to;
    clonedCar.route = cloned.getRoute(this.getRouteParts(0), this.getRouteParts(2));

    return clonedCar;

  }
}

