import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    while(sc.hasNext()){
      list.add(sc.next());
    }
    System.out.println(list);
  }
}