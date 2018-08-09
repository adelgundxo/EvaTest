import java.util.*;
import Features.*;
public class SC {


public static void main(String[] args){

int Min = 0;
int Max = 20;
int randomAmount = Min + (int)(Math.random() * ((Max - Min) + 1));
double num;
Map<Integer, Double> map = new HashMap<>();

for(int i = 0; i < randomAmount; i++){

num = Math.random();
map.put(i, num);

}

Operations operation = new Operations();
operation.doSomeMath(map);

}

}
