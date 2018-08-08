import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int amountKnownWords = sc.nextInt();
    Set<String> knownWords = new HashSet<>();
    Set<String> unknownWords = new HashSet<>();

    for(int i = 0; i < amountKnownWords; i++){
      knownWords.add(sc.next().toLowerCase());
    }
    sc.nextInt();

    while(sc.hasNext()){
      String var = sc.next().toLowerCase();
      if(!knownWords.contains(var)) {
        unknownWords.add(var);
      }
    }

    for (Object unknownWord : unknownWords) {
      System.out.println(unknownWord);
    }
  }
}