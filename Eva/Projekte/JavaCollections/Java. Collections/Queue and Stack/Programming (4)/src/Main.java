
import java.util.Scanner;
import java.util.Stack;

public class Main {



  public static void main(String[] args) {
    Stack<Character> stack = new Stack<>();
    Scanner sc = new Scanner(System.in);
    String next;



    if (sc.hasNext()) {

      next = sc.next();
      if (next.length() % 2 != 0) {

        System.out.println("false");
        System.exit(0);
      }
      System.err.println(next);
        char[] input = next.toCharArray();

        for (int i = 0; i < input.length; i++) {
          if (input[i] == '(' || input[i] == '{' || input[i] == '[') {
            stack.push(input[i]);
          }
          if(stack.isEmpty()){
            System.out.println("false");
            System.exit(0);
          }

          if (input[i] == ')') {
            if (stack.peek() == '(') {
              stack.pop();
            }
          } else if (input[i] == '}') {
            if (stack.peek() == '{') {
              stack.pop();
            }
          } else if (input[i] == ']') {
            if (stack.peek() == '[') {
              stack.pop();
            }
          }
        }

      }



    System.out.println(stack.isEmpty());


  }
}