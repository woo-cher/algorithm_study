package b2493;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int input = s.nextInt();
    int top[] = new int[input];
    
    for (int i = 0; i < input; i++)
      top[i] = s.nextInt();
    
    System.out.print("0 " + (top[1] - top[0] > 0 ? "0 " : "1 "));
    
    for (int i = 2; i < input; i++) {
      for (int j = i - 1; j >= -1; j--) {
        if (j < 0) {
          System.out.print("0 ");
          break;
        }
        if (top[i] - top[j] < 0) {
          System.out.print((j + 1) + " ");
          break;
        }
      }
    }
    s.close();
  }
}