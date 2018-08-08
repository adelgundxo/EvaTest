
public class Main {


public static void main(String[] args){

  double num1 = Math.random();
  double num2 = Math.random();

  calculateMean(num1, num2);
}

public static void calculateMean(double num1, double num2){

  double result = (num1 + num2)/2;
  System.out.println("Mean of two random values: " + result);
}


}
