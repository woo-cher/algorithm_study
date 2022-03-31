package goorm.level2.계산기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String answer = switch (input[1]) {
            case "+" -> String.valueOf(Integer.parseInt(input[0]) + Integer.parseInt(input[2]));
            case "-" -> String.valueOf(Integer.parseInt(input[0]) - Integer.parseInt(input[2]));
            case "*" -> String.valueOf(Integer.parseInt(input[0]) * Integer.parseInt(input[2]));
            default ->  String.format("%.2f", Float.parseFloat(input[0]) / Float.parseFloat(input[2]));
        };

        System.out.print(answer);
    }
}
