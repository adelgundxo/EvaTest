import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    ArrayList<Integer> filler = new ArrayList<>();

      while(sc.hasNextInt()){
        filler.add(sc.nextInt());
      }

      for(int i = 1; i < filler.size(); i++){
        if(filler.get(i) % 2 == 0){
          deque.addFirst(filler.get(i));
        } else{
          deque.addLast(filler.get(i));
        }
      }

    for(int i = 0; i < deque.size(); i++){
      System.out.println(deque.removeFirst());
      i--;
    }
  }
}