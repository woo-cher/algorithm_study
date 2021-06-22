package programmers.level1.평균구하기;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,5}));
    }

    public static double solution(int[] arr) {
        int sum = 0;

        for (int n : arr) {
            sum += n;
        }

        return (double) sum / arr.length;
    }
}
