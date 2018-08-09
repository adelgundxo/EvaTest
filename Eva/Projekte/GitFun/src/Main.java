
public class Main {


  public static void main(String[] args) {

    double num1 = Math.random();
    double num2 = Math.random();

    calculateMean(num1, num2);
    calculateSum(num1, num2);
    calculateDiff(num1, num2);
  }

  public static void calculateMean(double num1, double num2) {

    double result = (num1 + num2) / 2;
    System.out.println("Mean of two random values: " + result);
  }

  public static void calculateSum(double num1, double num2) {
    double sum = num1 + num2;
    System.out.println("This is the sum of our nums:" + sum);
  }

  public static void calculateDiff(double num1, double num2) {
    double diff;
    if (num1 > num2) {
      diff = num1 - num2;
    } else {
      diff = num2 - num1;
    }
    System.out.println("This is the difference: " + diff);
    
  }
}
