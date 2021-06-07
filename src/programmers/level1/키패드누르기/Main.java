package programmers.level1.키패드누르기;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        int index[][] = {{3, 0}, {0, 1}, {3, 2}}; // index of [`left', `mid, 'right']
        String left = "147*";
        String mid = "2580";
        String right = "369#";
        String result = "";

        for (int key : numbers) {
            String strKey = String.valueOf(key);

            if (left.contains(strKey)) {
                index[0][1] = 0;
                index[0][0] = left.indexOf(strKey);
                result += "L";
            } else if (right.contains(strKey)) {
                index[2][1] = 2;
                index[2][0] = right.indexOf(strKey);
                result += "R";
            } else {
                index[1][0] = mid.indexOf(strKey);

                int leftDistance = getDistance(index[1], index[0]);
                int rightDistance = getDistance(index[1], index[2]);

                if (leftDistance == rightDistance) {
                    String handValue = String.valueOf(hand.charAt(0)).toUpperCase(); // Get first index of `hand`
                    result += handValue;
                } else if (leftDistance > rightDistance) {
                    result += "R";
                } else {
                    result += "L";
                }

                int midX = index[1][0];
                int midY = index[1][1];

                if (result.endsWith("L")) {
                    index[0][0] = midX;
                    index[0][1] = midY;
                } else {
                    index[2][0] = midX;
                    index[2][1] = midY;
                }
            }
        }

        return result;
    }

    public static int getDistance(int[] mid, int[] actual) {
        int abs = Math.abs(mid[0] - actual[0]);

        if (mid[1] == actual[1]) {
            return abs;
        } else
            return abs + 1;
    }
}
