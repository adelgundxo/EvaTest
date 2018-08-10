import Model.Wild;

public class SP {

  public static void main(String[] args){
    int i = 50;
    String s ="foo";
    String b = "ba";
    printRecur(s , i);
    printIter(b, i);
    Wild wild = new Wild(s,b);
    wild.runWild();
    wild.runSmooth();
  }

  public static void printRecur(String s, int i){

    if(i == 0){
      return;
    }
    System.out.println(s);
    i--;
    printRecur(s, i);
  }

  public static void printIter(String s, int i){
    for (int j = 0; j < i; j++) {
      System.out.println(s);
    }
  }
}


