public class SP {

  public static void main(String[] args){
    int i = 50;
    String s ="foo";
    printRecur(s , i);
  }

  public static void printRecur(String s, int i){

    if(i == 0){
      return;
    }
    System.out.println(s);
    i--;
    printRecur(s, i);
  }
}


