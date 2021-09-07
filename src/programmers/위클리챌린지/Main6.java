package programmers.위클리챌린지;


import java.util.Arrays;
import java.util.PriorityQueue;

// 6주차
public class Main6 {
    public static int[] solution(int[] weights, String[] head2head) {
        int answer[] = new int[weights.length];

        PriorityQueue<Player> queue = new PriorityQueue<>();

        for (int i = 0; i < weights.length; i++) {
            int w = weights[i];
            String h2h = head2head[i];

            int winHeavierCnt = getCntToWinHeavier(weights, w, h2h);
            Player player = new Player(i + 1, w, getRating(h2h), winHeavierCnt);
            queue.add(player);
        }

        int i = 0;
        while (!queue.isEmpty()) {
            answer[i++] = queue.poll().num;
        }

        return answer;
    }

    public static int getCntToWinHeavier(int[] weights, int myWeight, String h2h) {
        int cnt = 0;

        for (int i = 0; i < h2h.length(); i++) {
            char c = h2h.charAt(i);

            if (c == 'W') {
                if (myWeight < weights[i]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static double getRating(String h2h) {
        double all = h2h.length();
        double win = 0;

        for (int i = 0; i < h2h.length(); i++) {
            char c = h2h.charAt(i);

            if (c != 'N') {
                if (c == 'W') {
                    win++;
                }
            } else {
                all--;
            }
        }

        return all == 0 ? 0 : win / all;
    }

    public static void main(String[] args) {
        int[] weight = {60, 70, 60};
        int[] weight2 = {145, 92, 86};
        String[] head2head = {"NNN", "NNN", "NNN"};
        String[] head2head2 = {"NLW", "WNL", "LWN"};

        System.out.println(Arrays.toString(solution(weight, head2head)));
        System.out.println(Arrays.toString(solution(weight2, head2head2)));
    }
}

class Player implements Comparable<Player> {
    public int num;
    public int weights;
    public double rating;
    public int winHeavier;

    public Player(int num, int weights, double rating, int winHeavier) {
        this.num = num;
        this.weights = weights;
        this.rating = rating;
        this.winHeavier = winHeavier;
    }

    @Override
    public int compareTo(Player o) {
        if (this.rating != o.rating) {
            return Double.compare(o.rating, this.rating);
        } else if (this.winHeavier != o.winHeavier) {
            return Integer.compare(o.winHeavier, this.winHeavier);
        } else if (this.weights != o.weights) {
            return Integer.compare(o.weights, this.weights);
        } else {
            return Integer.compare(this.num, o.num);
        }
    }
}

