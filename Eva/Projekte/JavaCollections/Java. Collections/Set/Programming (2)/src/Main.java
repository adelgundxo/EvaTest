import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {

    TreeSet<String> set = new TreeSet<>();
    Scanner sc = new Scanner(System.in);
    sc.next();


      while(sc.hasNext()){
        set.add(sc.next());
      }

    Iterator<String> iter = set.iterator();

      while(iter.hasNext()){
        System.out.println(iter.next());
      }


  }

}