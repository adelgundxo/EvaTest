import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int rows = sc.nextInt();
    int columns = sc.nextInt();
    int table[][] = new int[rows][columns];

    for(int i = 0; i < rows; i++){
      for(int j = 0; j < columns; j++){
        table[i][j] = sc.nextInt();
      }
    }

    int rotateDistance = sc.nextInt();

    for (int i = 0; i < table.length; i++) {
      for(int j = 0; j < table.length; j++){
        System.out.print(table[i][j] + " ");
          if (j == 2){
            System.out.print("\n");
          }
      }

    }

    System.out.println("Rotate Distance :" + rotateDistance);
    System.out.println("Rotate Distance :" + rotateDistance);

  }
}