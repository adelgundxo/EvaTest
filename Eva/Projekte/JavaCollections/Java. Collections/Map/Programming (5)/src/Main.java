import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) {
    SortedMap<Integer, String> pairs = new TreeMap<>();
    Scanner sc = new Scanner(System.in);
    int from = sc.nextInt();
    int to = sc.nextInt();
    int amount = sc.nextInt();

   for (int i = 0; i < amount; i++){
     pairs.put(sc.nextInt(), sc.next());
   }

   for (Map.Entry<Integer, String> printer : pairs.entrySet()){
     if(printer.getKey() >= from && printer.getKey() <= to){
       System.out.println(printer.getKey() + " " + printer.getValue());
     }
   }
  }
}