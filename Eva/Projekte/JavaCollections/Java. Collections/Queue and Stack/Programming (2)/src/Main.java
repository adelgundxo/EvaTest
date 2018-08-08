import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    ArrayDeque<Integer> deque = new ArrayDeque<>();
    Scanner sc = new Scanner(System.in);

      while(sc.hasNextInt()){
        deque.add(sc.nextInt());
      }
    for(int i = 0; i < deque.size() -1; i++){
      System.out.println(deque.peekLast());
      deque.removeLast();
      i--;
    }
  }
}