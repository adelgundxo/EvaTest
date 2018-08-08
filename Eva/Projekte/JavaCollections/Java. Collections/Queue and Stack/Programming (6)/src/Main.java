import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

  static Stack stack = new Stack();

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    ArrayList commands = new ArrayList();
    String next;

    while (sc.hasNext()) {
      next = sc.next();
      if (next.length() > 1) {
        commands.add(next);
      }
    }
  }
}
