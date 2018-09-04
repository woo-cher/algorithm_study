package b9012;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int index = 0;
    int num = s.nextInt();
    String flag[] = new String[num];
    
    // input and process
    while (num--> 0) {
      int cnt = 0;
      String str = s.next();
      
      if (str.length() < 2 || str.length() > 50)
        continue;
      
      for (int i = 0; i < str.length(); i++) {
        if (cnt < 0)
          break;
        
        cnt += str.charAt(i) == '(' ? 1 : -1;
      }
      
      flag[index++] = cnt == 0 ? "YES" : "NO";
    }
    
    //output
    for (int i = 0; i < flag.length; i++) {
      System.out.println(flag[i]);
    }
    flag = null;
    s.close();
  }
}