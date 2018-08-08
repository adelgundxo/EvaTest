import java.util.*;

public class Main {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    String[] listFill = sc.nextLine().split(" ");
    for (int i = 0; i < listFill.length; i++) {
      list.add(Integer.parseInt(listFill[i]));
    }
    int numOfSwaps = sc.nextInt();

    for (int i = 0; i < numOfSwaps; i++) {
      Collections.swap(list, sc.nextInt(), sc.nextInt());
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + " ");
    }


  }
}