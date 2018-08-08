import java.util.*;

public class Main {

  public static void main(String[] args) {

    Deque<Integer> queue = new ArrayDeque<>(Arrays.asList(1,2,3,4));

    queue.addLast(5);
    queue.pollFirst();
    queue.pollFirst();


    System.out.println(queue);

  }
}