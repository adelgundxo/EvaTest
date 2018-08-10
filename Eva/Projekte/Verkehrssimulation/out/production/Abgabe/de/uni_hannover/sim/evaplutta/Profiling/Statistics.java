package de.uni_hannover.sim.evaplutta.Profiling;
import java.util.*;
public class Statistics {

  /**
   * Finds the greatest value in data. This method assumes that the array is already sorted in ascending order.
   *
   * @param data An arbitrary number of sorted double values
   * @return A greatest value in data
   */
  public static double calculateMax(double[] data) {
    // TODO: Find a more simple solution
    return data[data.length - 1];
  }


  public static double calculateMin(double[] data){
        
        return data[0];
    }
/** calculates standard deviation of data
*@param data is a List of Doubles
*@return the mean value of data
*/
  public static double calculateMean(ArrayList<Double> data){
  double mean = 0;
    for(int i = 0; i < data.size(); i++){
    mean = mean + data.get(i);
    }
    mean = mean/data.size();
    return mean;
  }
  
  public static double calculateMedian(double[] data){

  int middle = (data.length - 1)/2;
 
      return data[middle];  
  }
  /**calculates standard deviation of data
  *@param data list of doubles
  *@return standard deviation of values
  */
    public static double calculateStandardDeviation(ArrayList<Double> data){
    double sd = 0.0;
        for(int i = 0; i < data.size(); i++){
        sd = sd + ((data.get(i) - calculateMean(data))*(data.get(i) - calculateMean(data)));
        }
        
        sd = sd/data.size();
        sd = Math.sqrt(sd);
        return sd;
    }

  public static double calculateRange(double[] data){
  
    double range = calculateMax(data) - calculateMin(data);
    return range;
  }

  public static double calculateLowerQuartile(double[] data){
  
  int quarter = ((data.length - 1)/4);
  
  return data[quarter];
  
  }
  
  public static double calculateUpperQuartile(double[] data){
    int quarter = ((data.length - 1 )/4);
    int lastquarter = (data.length - 1) - quarter - 1;
    return data[lastquarter];
  }
}


