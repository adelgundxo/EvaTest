package Features;
import java.util.*;
public class Operations {
 private String s;
 private double sum;
 private int amountOfNumbers;
 

   public Operations() {
        s = "Welcome to SuperCalculator5000!";
    }
    
    
public void doSomeMath(Map<Integer,Double> map){
amountOfNumbers = 0;

    for(Map.Entry<Integer, Double> counter : map.entrySet()){
    amountOfNumbers++;
    }
System.out.println(amountOfNumbers + "Numbers added.");
sum(map);

}

private void sum(Map<Integer, Double> map){

sum = 0.0;

for(Map.Entry<Integer,Double> pairs : map.entrySet()){

    sum += pairs.getValue();
   
}
 this.print(sum);
}

private void print(double sum){

System.out.println(s);
System.out.println("This is the sum of many or not so many random values: " + sum);

}
 

}







