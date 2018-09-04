package b10162;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int input;
    int btn[] = {300, 60, 10};
    int push[] = {0, 0, 0};
    
    // input
    input = s.nextInt();
    
    // process
    for (int i = 0; i < btn.length; i++) {
      push[i] = input / btn[i];
      input %= btn[i];
    }
    
    // output
    if (input == 0) {
      for (int i = 0; i < push.length; i++)
        System.out.print(push[i] + " ");
    }
    else System.out.print("-1");
     
    s.close();
  }
}
