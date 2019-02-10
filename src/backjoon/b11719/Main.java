package backjoon.b11719;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    List<String> strList = new ArrayList<>();
    while (s.hasNextLine()) {
      strList.add(s.nextLine());
    }
    for (String str : strList) {
      System.out.println(str);
    }
  }
}
