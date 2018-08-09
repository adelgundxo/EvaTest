package Model;

import static java.lang.Thread.sleep;

public class Wild {
  private String u;
  private String s;
  private int lel = 10;

  public Wild(String s, String u){
    this.s = s;
    this.u = u;
  }

  public void runWild(){


    for (int i = 0; i < 50 ; i++) {
      for (int o = 0; o <50 ; o++) {
        try {
          sleep(13);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        for (int p = 0; p <50 ; p++) {
          for (int l = 0; l <50 ; l++) {
            System.out.print(s);
          }
          System.out.print(u);
        }
      }
      try {
        sleep(20);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void runSmooth(){
    System.out.println("This is a String: " + u);
    System.out.println("This is a String too: " + s);
    try {
      sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("This is not a String: " + lel);
  }


}
