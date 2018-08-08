import java.util.*;

public class Main {

  public static void main(String[] args) {

    ArrayList<Integer> result = new ArrayList<>();
    List<Integer> list = readIntegersFromStdIn();

    for (int i = 0; i < list.size(); i++) {
      if(i % 2 != 0){
        result.add(list.get(i));
      }
    }
    Collections.reverse(result);

    for (Integer integer : result) {
      System.out.print(integer + " ");
    }
  }

  private static List<Integer> readIntegersFromStdIn(){
    List<Integer> ints = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    while (sc.hasNextInt()){
      ints.add(sc.nextInt());
    }
    return ints;
  }
}