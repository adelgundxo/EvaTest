import java.util.*;

public class Main {


  static Map<String, String> dict = new HashMap<>();

  public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);

    String[] alphabet = sc.next().split("");
    String[] cypher = sc.next().split("");
    String[] toEncode = sc.next().split("");
    String[] toDecode = sc.next().split("");
    for (int i = 0; i < alphabet.length; i++) {
      dict.put(alphabet[i], cypher[i]);
    }

    System.out.println(encode(toEncode));
    System.out.println(decode(toDecode));

  }

  private static String encode(String[] toEncode) {
    StringBuilder sb = new StringBuilder();
    for (String aToEncode : toEncode) {
      sb.append(dict.get(aToEncode));
    }
    return sb.toString();
  }

  private static String decode(String[] toDecode) {
    StringBuilder sb = new StringBuilder();
    for (String aToDecode : toDecode) {

      for (Map.Entry<String, String> diction : dict.entrySet()) {

        if (aToDecode.equals(diction.getValue())) {
          sb.append(diction.getKey());
        }
      }

    }
    return sb.toString();
  }

}
