package Features;

import java.util.*;

public class Operations {
  private String s;
  private double sum;
  private int amountOfNumbers;
  private double product;


  public Operations() {
    s = "Welcome to SuperCalculator5000!";
  }


  public void doSomeMath(Map<Integer, Double> map) {
    amountOfNumbers = 0;

    for (Map.Entry<Integer, Double> counter : map.entrySet()) {
      amountOfNumbers++;
    }
    System.out.println(amountOfNumbers + "Numbers added.");
    sum(map);
    multiply(map);

  }

  private void sum(Map<Integer, Double> map) {

    sum = 0.0;

    for (Map.Entry<Integer, Double> pairs : map.entrySet()) {

      sum += pairs.getValue();

    }
    this.print(sum);
  }

  private void multiply(Map<Integer,Double> map){
    product = 0.0;

    for(Map.Entry<Integer, Double> mult : map.entrySet()){
      product = product * mult.getValue();
    }
    System.out.println(product);
  }

  private void print(double sum) {

    System.out.println(s);
    System.out.println("This is the sum of many or not so many random values: " + sum);


  }


}







