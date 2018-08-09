package Features;

import java.util.*;

public class Operations {
  private String s;
  private double sum;
  private double product;
  private double sumToDivide;
  private double division;


  public Operations() {
    s = "Welcome to SuperCalculator5000!";
  }


  public void doSomeMath(Map<Integer, Double> map, int amount) {


    System.out.println(amount+ "Numbers added.");
    sum(map);
    multiply(map);
    calculateMean(map, amount);

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
    System.out.println("This is the product: " + product);
  }

  private void print(double sum) {

    System.out.println(s);
    System.out.println("This is the sum of many or not so many random values: " + sum);


  }

  private void calculateMean(Map<Integer,Double> map, int amount){


    for(Map.Entry<Integer, Double> peers : map.entrySet()){
        sumToDivide += peers.getValue();
    }

    division = sumToDivide/((double)(amount));
    System.out.println("This is the mean value: " + division);
  }



}







