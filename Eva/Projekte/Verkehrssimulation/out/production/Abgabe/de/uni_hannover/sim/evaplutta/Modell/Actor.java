package de.uni_hannover.sim.evaplutta.Modell;
import de.uni_hannover.sim.evaplutta.Simulation.Simulation;

public abstract class Actor{
/**
* class Simulation, stores information for specific simulation
*/
  protected final Simulation simulation;
  /**
* name of object
*/
  protected final String name;

  public Actor(Simulation simulation, String name) {
    this.simulation = simulation;
    this.name = name;
    
  }
/**
* abstract update function, will be specified in classes which use this
*/
  public abstract void update();
  

  
  
  
}
