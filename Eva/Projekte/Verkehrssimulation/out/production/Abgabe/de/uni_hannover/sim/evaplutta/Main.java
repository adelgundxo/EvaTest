package de.uni_hannover.sim.evaplutta;
import de.uni_hannover.sim.evaplutta.Profiling.*;
import de.uni_hannover.sim.evaplutta.Modell.*;
import de.uni_hannover.sim.evaplutta.Simulation.*;
import java.util.*;


public class Main{

/**Main Method, accepts User inputs from terminal
*If user input is invalid value (negative Number or 0 for runtime and settling-time, negative number for repeat, settling time longer than runtime) the method will throw Exceptions
*/

public static void main (String[] args) throws Exception{

int timetest = 0;
for(int i = 0; i < args.length; i++){
    if(args[i].equals("-help")){
        System.out.println("Welcome to TrafficSimulator3000, you may find this helpful:");
        System.out.println("Use command -seed to set Random-Number-Generator");
        System.out.println("Use command -duration to set the duration of the Simulation");
        System.out.println("Use command -inspect <name1>,>name2> (for example: -inspect car1,car2,car3,CrossroadC,RoadAC) to show the status of the chosen cars, Crossroad C and the road from Crossroad A to Crossroad C");
        System.out.println("Use command -profile-cars to show statistics");
        System.out.println("Use command -repeat to repeat the Simulation x times.");
        System.out.println("Use command -settling-time to skip the first x timesteps (won't appear in statistics)");
        System.exit(0);
    }
    if(args[i].equals("-seed")){
        long seed = java.lang.Long.parseLong(args[i+1]);
        Simulation.setRnd(seed);
    }
    if(args[i].equals("-duration")){
        timetest = java.lang.Integer.parseInt(args[i+1]);
        if(timetest <= 0){
         throw new Exception("Plese set a time larger than 0, no negative numbers.");
        } else {
        Simulation.setTime(java.lang.Integer.parseInt(args[i+1]));
        }
    }
   
   if(args[i].equals("-inspect")){
        Simulation.setInspectednames(args[i+1].split(","));
    }
    if(args[i].equals("-profile-cars")){
        Simulation.setProtocoll(1);
    }
    if(args[i].equals("-settling-time")){
        int settlingtester = java.lang.Integer.parseInt(args[i+1]);
        if(settlingtester <= 0){
            throw new Exception("Simulation needs some time to settle. Please use a number > 0.");
        }
        if(settlingtester >= timetest){
            throw new Exception("settling-time needs to be SMALLER than duration.");
        }
        Simulation.setSettling(java.lang.Integer.parseInt(args[i+1]));
    }
    if(args[i].equals("-repeat")){
        if(java.lang.Integer.parseInt(args[i+1]) < 0){
            throw new Exception("You can't repeat something -x times");
        }
        Simulation.setRepeater(java.lang.Integer.parseInt(args[i+1]));
    }
}

Simulation simulation = new Simulation();
simulation.run();

}
}
