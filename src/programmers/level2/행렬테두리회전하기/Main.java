package programmers.level2.행렬테두리회전하기;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] q = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}};

        solution(6, 6, q);
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] m = new int[rows][columns];
        List<Integer> answer = new ArrayList<>();

        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                m[i][j] = value++;
            }
        }

        for (int[] query : queries) {
            List<Coordinate> nav = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();

            int minX = query[0] - 1;
            int minY = query[1] - 1;
            int maxX = query[2] - 1;
            int maxY = query[3] - 1;
            int minValue = m[minX][minY];

            setUpNavi(nav, maxX - minX, maxY - minY);
            temp.add(m[minX][minY]);

            for (Coordinate move : nav) {
                for (int i = 0; i < move.cnt; i++) {
                    minX += move.x;
                    minY += move.y;

                    int parse = m[minX][minY];
                    minValue = Math.min(minValue, parse);
                    temp.add(parse);
                }
            }

            rotate(m, nav, temp, query[0] - 1, query[1] - 1);
            answer.add(minValue);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void rotate(int[][] matrix, List<Coordinate> nav, List<Integer> temp, int x, int y) {
        matrix[x][y] = temp.get(temp.size() - 1);

        int i = 0;
        for (Coordinate move : nav) {
            for (int j = 0; j < move.cnt; j++) {
                x += move.x;
                y += move.y;
                matrix[x][y] = temp.get(i++);
            }
        }
    }

    public static void setUpNavi(List<Coordinate> list, int col, int row) {
        list.add(new Coordinate(0, 1, row));
        list.add(new Coordinate(1, 0, col));
        list.add(new Coordinate(0, -1, row));
        list.add(new Coordinate(-1, 0, col - 1));
    }
}

class Coordinate {
    int x;
    int y;
    int cnt;

    public Coordinate(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
