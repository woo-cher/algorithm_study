package goorm.level1.시험성적평균과등급구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] scores = input.split(" ");

        float sum = 0;
        for (String el : scores) {
            sum += Float.parseFloat(el);
        }

        float avg = Float.parseFloat(String.format("%.2f", sum / 3));

        String level = "";
        if (avg >= 90) {
            level = "A";
        } else if (avg < 90 && avg >= 80) {
            level = "B";
        } else if (avg < 80 && avg >= 70) {
            level = "C";
        } else if (avg < 70 && avg >= 60) {
            level = "D";
        } else {
            level = "F";
        }

        System.out.print(String.format("%.2f", avg) + " " + level);
    }
}
