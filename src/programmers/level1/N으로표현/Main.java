package programmers.level1.N으로표현;

public class Main {
    public static void main(String[] args) {
/*        int i = 1234;
        int cnt = 0;
        while(i > 0) {
            i = i / 10;
            cnt ++;
        }
        System.out.println("cnt = " + cnt);*/
        System.out.println(sub(5, 12));
    }

    public static int sub(int N, int number) {
        int min;
        int cnt = 0;
        int val = N * number;
        int i = 1;
        int j = 10;

        // number 자리수 구하기
        while(number > 0) {
            number /= 10;
            cnt++;
        }

        // 계산
        

        min = 3 + (number - i);

        if(min > 8)
            return -1;

        return min;
    }
}
