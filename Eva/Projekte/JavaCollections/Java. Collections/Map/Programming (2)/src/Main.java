
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    HashMap<String, Integer> map = new LinkedHashMap<>();
    Scanner sc = new Scanner(System.in);
    String newKey;

    while(sc.hasNext()){

      newKey = sc.next().toLowerCase();

      if(!map.containsKey(newKey)) {
        map.put(newKey, 1);
      } else {
        map.put(newKey, map.get(newKey) + 1);
      }
    }

    for(Map.Entry<String,Integer> entry : map.entrySet()){

      System.out.println( entry.getKey() + " " + entry.getValue());

    }
  }
}