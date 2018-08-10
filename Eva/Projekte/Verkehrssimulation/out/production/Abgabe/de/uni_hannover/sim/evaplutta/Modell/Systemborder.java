package de.uni_hannover.sim.evaplutta.Modell;

import de.uni_hannover.sim.evaplutta.Simulation.*;

import java.util.*;

public class Systemborder extends Crossroad {
  /**
   * represents spawn-probability (how many cars are assumed to be spawned at this border
   */
  private double probability;
  /**
   * list of possible routes to choose from
   */
  private ArrayList<ArrayList<Crossroad>> possibleroutes;
  /**
   * index for choosing a random route from possibleroutes
   */
  private int routechoose;
  /**
   * random number has to be lower than spawn-probability to spawn cars
   */
  private double randomnumber;
  /**
   * represents the randomly picked route
   */
  private ArrayList<Crossroad> thisroute;
  /**
   * startpoint
   */
  private Crossroad routebegin;
  /**
   * endpoint
   */
  private Crossroad routeending;
  /**
   * brand of a car
   */
  private String carname;

  private int identify = 1;

  private Systemborder copy;


  public Systemborder(String name, Road innorth, Road outnorth, Road insouth, Road outsouth, Road inwest, Road outwest, Road ineast, Road outeast, double probability, ArrayList<ArrayList<Crossroad>> possibleroutes, Simulation simulation) {

    super(name, innorth, outnorth, insouth, outsouth, inwest, outwest, ineast, outeast, simulation);

    this.possibleroutes = possibleroutes;
    this.probability = probability;


  }

  /**
   * @param -
   * @return spawn-probability
   */
  public double getProbability() {
    return probability;
  }

  /**
   * @param  i probability to be assigned to the variable
   * @return -
   */
  public void setProbability(double i) {
    probability = i;
  }

  /**
   * @param -
   * @return list of routes from which to choose
   */
  public ArrayList<ArrayList<Crossroad>> getPossibleRoutes() {
    return possibleroutes;
  }

  /**
   * @param routes to set
   * @return -
   */
  public void setPossibleRoutes(ArrayList<ArrayList<Crossroad>> routes) {
    possibleroutes = routes;
  }

  /**
   * @param -
   * @return randomly chosen car-name
   */
  private String getRandomName() {

    int rnd = Simulation.getRnd().nextInt(10);
    if (rnd == 0) {
      return "VW";
    }
    if (rnd == 1) {
      return "BMW";
    }
    if (rnd == 2) {
      return "Opel";
    }
    if (rnd == 3) {
      return "Dacia";
    }
    if (rnd == 4) {
      return "Ford";
    }
    if (rnd == 5) {
      return "Lamborghini";
    }
    if (rnd == 6) {
      return "Porsche";
    }
    if (rnd == 7) {
      return "Trabant";
    }
    if (rnd == 8) {
      return "Renault";
    } else {
      return "Audi";
    }

  }

  /**
   * @param -
   * @return -
   * spawn new car if randomnumber is smaller than probability and 0.th slot of road is free, assign a name and a randomly chosen route. Add car to evaluation-list (activeactors) if name has been mentioned by user on cmd
   */
  @Override
  public void update() {

    routechoose = Simulation.getRnd().nextInt(2);
    randomnumber = Simulation.getRnd().nextDouble();

    if (randomnumber < probability) {

      thisroute = possibleroutes.get(routechoose);
      routebegin = thisroute.get(routechoose);
      routeending = thisroute.get(routechoose + 1);

      if (thisroute.get(0).getroad(routebegin, routeending).getLegal(0) == 0) {

        Car car = new Car(getRandomName(), 0, identify, thisroute, 0, simulation, true);
        simulation.getActors().add(car);
        identify++;
        for (String name : Simulation.getInspectednames()) {

          if (name.equals(car.getName())) {
            simulation.getActiveactors().add(car);
          }
        }


      }
    }

  }


}